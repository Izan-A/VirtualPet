import java.util.Random;
import java.util.Scanner;

// Esta clase es la mascota, aqui guardo todos sus datos
class Mascota {
    String nombre;
    String tipo;
    int energia;
    int higiene;
    int peso;
    int animo;

    //Constructores
    Mascota(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        if (tipo.equals("dummy")) {
            peso = 100;
        } else {
            Random r = new Random();
            peso = r.nextInt(21) + 40;
        }
        if (tipo.equals("dummy")) {
            energia = 100;
        } else {
            Random r = new Random();
            energia = r.nextInt(21) + 40;
        }
        if (tipo.equals("dummy")) {
            higiene = 100;
        } else {
            Random r = new Random();
            higiene = r.nextInt(21) + 40;
        }
        if (tipo.equals("dummy")) {
            animo = 100;
        } else {
            Random r = new Random();
            animo = r.nextInt(21) + 40;
        }
    } // aqui se cierra el constructor

    // Este metodo imprime como esta la mascota
    void mostrar() {
        System.out.println();
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Energia: " + energia);
        System.out.println("Higiene: " + higiene);
        System.out.println("Peso: " + peso);
        System.out.println("Animo: " + animo);
        System.out.println();
    }

    // Devuelve true si la mascota se murio (algo llego a 0 o paso de 100)
    boolean estaMuerta() {
        if (energia <= 0 || energia > 100) {
            return true;
        }
        if (higiene <= 0 || higiene > 100) {
            return true;
        }
        if (peso <= 0 || peso > 100) {
            return true;
        }
        if (animo <= 0 || animo > 100) {
            return true;
        }
        return false; // si no entro en ningun if, sigue viva
    }

    // Opcion 1: dormir
    void dormir() {
        if (tipo.equals("perro")) {
            energia = energia + 25; // el perro gana 25
        } else {
            energia = energia + 20; // el gato gana 20
        }
        animo = animo + 10; // el animo sube 10 en los dos
    }

    // Opcion 2: jugar
    void jugar() {
        energia = energia - 20;
        animo = animo + 20;
        peso = peso - 10;
    }

    // Opcion 3: comer
    void comer() {
        energia = energia + 10;
        higiene = higiene - 15;
        peso = peso + 10;
    }

    // Opcion 4: limpiar, cambia si es perro o gato
    void limpiar() {
        if (tipo.equals("perro")) {
            energia = energia - 10;
            higiene = higiene + 25;
            animo = animo - 15;
        } else {
            energia = energia - 5;
            higiene = higiene + 25;
            animo = animo + 5;
        }
    }
}