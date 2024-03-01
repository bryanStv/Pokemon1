import java.sql.*;

public class ConsultarBBDD {
    private static final String url = "jdbc:sqlite:/home/bryan/IdeaProjects/Pokemon1/bd/network.db";
    private static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(url);
    }
    public static void todosLosPokemon(){
        String consulta = "SELECT * FROM pokemon ORDER BY 3";
    try(Connection connection = obtenerConexion();
        PreparedStatement pstmt = connection.prepareStatement(consulta)){
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(3));;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
