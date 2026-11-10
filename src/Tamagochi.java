import java.util.Scanner;

public class Tamagochi {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // para leer lo que escribe el usuario

        System.out.println("Bienvenido al Tamagochi!");

        // Pregunto el tipo hasta que escriba perro o gato
        String tipo = "";
        while (!tipo.equals("perro") && !tipo.equals("gato")) {
            System.out.print("Quieres un perro o un gato? ");
            tipo = teclado.nextLine().toLowerCase();
        }

        System.out.print("Como se llama tu mascota? ");
        String nombre = teclado.nextLine();

        // Creo mi mascota y el dummy para poder atacarlo
        Mascota miMascota = new Mascota(nombre, tipo);
        Mascota dummy = new Mascota("Dummy", "dummy");

        int opcion = -1;

        // El menu se repite hasta que el usuario pone 0
        while (opcion != 0) {
            miMascota.mostrar();

            System.out.println("1.- Dormir");
            System.out.println("2.- Jugar");
            System.out.println("3.- Comer");
            System.out.println("4.- Limpiar");
            System.out.println("5.- Atacar");
            System.out.println("6. Bailar");
            System.out.println("0.- Salir");
            System.out.print("Elige una opcion: ");

            // try catch por si el usuario escribe letras en vez de un numero
            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un numero!");
                continue; // vuelve al principio del while
            }

            // Segun la opcion llamo al metodo que toca
            if (opcion == 1) {
                miMascota.dormir();
            } else if (opcion == 2) {
                miMascota.jugar();
            } else if (opcion == 3) {
                miMascota.comer();
            } else if (opcion == 4) {
                miMascota.limpiar();
            } else if (opcion == 5) {
                System.out.print("Cuantas veces quieres atacar? ");
                int veces = Integer.parseInt(teclado.nextLine());

                // Bucle for: se repite tantas veces como diga el usuario
                for (int i = 1; i <= veces; i++) {
                    // los dos pierden 3 de energia, higiene y animo
                    miMascota.energia = miMascota.energia - 3;
                    miMascota.higiene = miMascota.higiene - 3;
                    miMascota.animo = miMascota.animo - 3;
                    dummy.energia = dummy.energia - 3;
                    dummy.higiene = dummy.higiene - 3;
                    dummy.animo = dummy.animo - 3;

                    System.out.println("Ataque numero " + i);

                    // si alguno se muere, paro el bucle con break
                    if (miMascota.estaMuerta() || dummy.estaMuerta()) {
                        break;

                    }
                }
                dummy.mostrar();
            } else if (opcion == 0) {
                System.out.println("Adios!");
            } else {
                System.out.println("Opcion no valida");
            }

            // Despues de cada accion miro si alguien se murio
            if (miMascota.estaMuerta()) {
                miMascota.mostrar();
                System.out.println(miMascota.nombre + " ha muerto... GAME OVER");
                break; // salgo del while y se acaba el juego
            }
            if (dummy.estaMuerta()) {
                System.out.println("El dummy ha muerto... GAME OVER");
                break;
            }
        }

        teclado.close();
    }
}
