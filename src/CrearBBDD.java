import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CrearBBDD {
    public CrearBBDD(){}
    public void crearTabla(){
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/home/bryan/IdeaProjects/Pokemon1/bd/network.db";
            con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            String sql = "CREATE TABLE pokemon (" +
                    "idP INTEGER PRIMARY KEY," +
                    "id INTEGER," +
                    "nombre VARCHAR(40)," +
                    "tipo1 VARCHAR(15)," +
                    "tipo2 VARCHAR(15)," +
                    "total SMALLINT," +
                    "hp SMALLINT," +
                    "ataque SMALLINT," +
                    "defensa SMALLINT," +
                    "ataqueEspecial SMALLINT," +
                    "defensaEspecial SMALLINT," +
                    "velocidad SMALLINT," +
                    "generation SMALLINT," +
                    "legendario INTEGER CHECK (legendario IN (0,1))" +
                    ");";

            st.executeUpdate(sql);
            System.out.println("Tabla creada con exito");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (con != null){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void addTodosLosPokemon() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/home/bryan/IdeaProjects/Pokemon1/bd/network.db";
            con = DriverManager.getConnection(url);
            insertarDatosCSV(con,"bd/pokemon.csv");
            System.out.println("Datos insertados con éxito");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void insertarDatosCSV(Connection connection, String archivoCSV) throws SQLException {
        String sql = "INSERT INTO pokemon (id, nombre, tipo1, tipo2, total, hp, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, generation, legendario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            BufferedReader line = new BufferedReader(new FileReader("files/pokemon.csv"));
            PreparedStatement pstmt = connection.prepareStatement(sql);
            line.readLine();
            String[] pokemons;
            String linea;
            while((linea = line.readLine()) != null){
                pokemons = linea.split(",");
                pstmt.setInt(1, convertirAEntero(pokemons[0]));
                pstmt.setString(2, pokemons[1]);
                pstmt.setString(3, pokemons[2]);
                if(!pokemons[3].equals(" ")) {
                    pstmt.setString(4, pokemons[3]);
                }else{
                    pstmt.setString(4,null);
                }
                pstmt.setInt(5, convertirAEntero(pokemons[4]));
                pstmt.setInt(6, convertirAEntero(pokemons[5]));
                pstmt.setInt(7, convertirAEntero(pokemons[6]));
                pstmt.setInt(8, convertirAEntero(pokemons[7]));
                pstmt.setInt(9, convertirAEntero(pokemons[8]));
                pstmt.setInt(10, convertirAEntero(pokemons[9]));
                pstmt.setInt(11, convertirAEntero(pokemons[10]));
                pstmt.setInt(12, convertirAEntero(pokemons[11]));
                pstmt.setBoolean(13, Boolean.parseBoolean(pokemons[12]));
                pstmt.executeUpdate();
            }
        }catch (IOException e){
            System.out.println("El fichero no existe");
        }
    }
    private static int convertirAEntero(String dato){
        return Integer.parseInt(dato);
    }
}
