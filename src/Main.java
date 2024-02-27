import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pokemon> pokedex = new ArrayList<>(800);
        cargarTodosLosPokemon(pokedex);
        menu(pokedex);
    }

    public static void menu(ArrayList<Pokemon> pokedex){
        Scanner tc = new Scanner(System.in);
        System.out.println("Bienvenido a la pokedex 1.0");
        System.out.println("Qué quieres hacer: ");
        System.out.println("\t\tListar todos los pokemon(1)");
        System.out.println("\t\tListar todos los pokemon de una generación determinada(2)");
        System.out.println("\t\tListar sólo los pokemon de un tipo en específico(3)");
        System.out.println("\t\tBuscar un pokemon en específico(4)");
        System.out.print("Qué opción eliges: ");
        int opcion = tc.nextInt();
        switch (opcion){
            case 1:
                listarTodosLosPokemon(pokedex);
                break;
            case 2:
                System.out.println("Generaciones del 1-6");
                System.out.print("Dime la generación que buscas: ");
                int gen = tc.nextInt();
                listarPorGeneracion(gen,pokedex);
                break;
            case 3:
                System.out.println("Los tipos son Grass, Poison, Fire, Flying, Bug, Water, Dragon, Normal, Electric, Ground, Fairy, Fighting, Rock, Steel, Ice, Psychic y Ghost");
                System.out.print("Dime que tipo buscas: ");
                String tipo = tc.next();
                listarPorTipo(tipo,pokedex);
                break;
            case 4:
                System.out.print("Dime el nombre del pokémon a buscar: ");
                String nombre = tc.next();
                buscarPokemon(nombre,pokedex);
                break;
            default:
                System.out.println("Elige una opción correcta");
                menu(pokedex);
        }
        tc.close();
    }

    private static void listarPorTipo(String tipo,ArrayList<Pokemon> pokedex){
        for (Pokemon p: pokedex){
            if(p.getTipo1().compareTo(tipo) == 0 || p.getTipo2().compareTo(tipo) == 0){
                System.out.println(p);
            }
        }
    }
    private static void listarPorGeneracion(int generacion,ArrayList<Pokemon> pokedex){
        for(Pokemon p : pokedex){
            if(p.getGeneracion()==generacion){
                System.out.println(p);
            }
        }
    }
    private static void listarTodosLosPokemon(ArrayList<Pokemon> pokedex){
        for(Pokemon p : pokedex){
            System.out.println(p);
        }
    }
    private static void buscarPokemon(String nombre, ArrayList<Pokemon> pokedex){
        for(Pokemon p : pokedex){
            if(p.getNombre().compareTo(nombre) == 0){
                System.out.println(p);
            }
        }
    }

    private static void cargarTodosLosPokemon(ArrayList<Pokemon> pokedex){
        try{
            BufferedReader line = new BufferedReader(new FileReader("files/pokemon.csv"));
            line.readLine();
            String[] pokemons = new String[13];
            String linea;
            int id,total,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,generacion;
            String nombre,tipo1,tipo2;
            boolean legendario;
            while((linea = line.readLine()) != null){
                pokemons = linea.split(",");
                id = convertirAEntero(pokemons[0]);
                nombre = pokemons[1];
                tipo1 = pokemons[2];
                tipo2 = pokemons[3];
                total = convertirAEntero(pokemons[4]);
                hp = convertirAEntero(pokemons[5]);
                ataque = convertirAEntero(pokemons[6]);
                defensa = convertirAEntero(pokemons[7]);
                ataqueEspecial = convertirAEntero(pokemons[8]);
                defensaEspecial = convertirAEntero(pokemons[9]);
                velocidad = convertirAEntero(pokemons[10]);
                generacion = convertirAEntero(pokemons[11]);
                legendario = Boolean.parseBoolean(pokemons[12]);
                if(tipo2 != " "){
                    Pokemon poke = new Pokemon(id,nombre,tipo1,tipo2,total,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,generacion,legendario);
                    pokedex.add(poke);
                }else{
                    Pokemon poke = new Pokemon(id,nombre,tipo1,total,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,generacion,legendario);
                    pokedex.add(poke);
                }
            }
        }catch (IOException e){
            System.out.println("El fichero no existe");
        }
    }
    private static int convertirAEntero(String dato){
        return Integer.parseInt(dato);
    }
}
