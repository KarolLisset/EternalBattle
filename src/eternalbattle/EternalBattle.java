package eternalbattle;

import java.util.Scanner;

public class EternalBattle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario que elija raza y clase para el primer personaje
        System.out.println("Seleccione la clase del primer personaje:");
        System.out.println("1. Guerrero\n2. Mago\n3. Asesino");
        int clase1 = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.println("Seleccione la raza del primer personaje:");
        System.out.println("1. Humano\n2. Elfo\n3. Orco");
        int raza1 = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el nombre del primer personaje: ");
        String nombre1 = sc.nextLine();

        Personaje personaje1 = crearPersonaje(nombre1, clase1, raza1);

        // Solicitar al usuario que elija raza y clase para el segundo personaje
        System.out.println("Seleccione la clase del segundo personaje:");
        System.out.println("1. Guerrero\n2. Mago\n3. Asesino");
        int clase2 = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.println("Seleccione la raza del segundo personaje:");
        System.out.println("1. Humano\n2. Elfo\n3. Orco");
        int raza2 = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el nombre del segundo personaje: ");
        String nombre2 = sc.nextLine();

        Personaje personaje2 = crearPersonaje(nombre2, clase2, raza2);

        // Mostrar características de los personajes
        System.out.println("******Características de los contrincantes:*******");
        personaje1.mostrarPersonaje();
        System.out.println("------------");
        personaje2.mostrarPersonaje();
        System.out.println("------------");

        // Simular enfrentamiento
        enfrentarPersonajes(personaje1, personaje2);
    }

    public static Personaje crearPersonaje(String nombre, int clase, int raza) {
        Arma arma;
        Personaje personaje = null;

        switch (clase) {
            case 1: // Guerrero
                arma = new Arma("Espada", 0);
                if (raza == 1) personaje = new GuerreroHumano(nombre, 12, 100, 5, arma);
                else if (raza == 2) personaje = new GuerreroElfo(nombre, 10, 90, 6, arma);
                else if (raza == 3) personaje = new GuerreroOrco(nombre, 15, 110, 4, arma);
                break;
            case 2: // Mago
                arma = new Arma("Báculo", 0);
                if (raza == 1) personaje = new MagoHumano(nombre, 8, 80, 3, arma);
                else if (raza == 2) personaje = new MagoElfo(nombre, 9, 85, 4, arma);
                else if (raza == 3) personaje = new MagoOrco(nombre, 7, 75, 5, arma);
                break;
            case 3: // Asesino
                arma = new Arma("Daga", 0);
                if (raza == 1) personaje = new AsesinoHumano(nombre, 10, 90, 7, arma);
                else if (raza == 2) personaje = new AsesinoElfo(nombre, 11, 85, 8, arma);
                else if (raza == 3) personaje = new AsesinoOrco(nombre, 13, 95, 6, arma);
                break;
            default:
                System.out.println("Selección de clase inválida.");
        }
        return personaje;
    }

    public static void enfrentarPersonajes(Personaje p1, Personaje p2) {
        System.out.println("\nComienza el enfrentamiento:");
        System.out.println(p1.getNombre() + " vs " + p2.getNombre());
        int turnos = 0;
        final int MAX_TURNOS = 20; // Límite de turnos antes de declarar un empate

        while (p1.VerificarVitalidad() && p2.VerificarVitalidad() && turnos < MAX_TURNOS) {
            // Turno de p1
            p1.atacar(p2);
            if (!p2.VerificarVitalidad()) {
                System.out.println(p2.getNombre() + " ha sido derrotado.");
                break;
            }
            // Turno de p2
            p2.atacar(p1);
            if (!p1.VerificarVitalidad()) {
                System.out.println(p1.getNombre() + " ha sido derrotado.");
                break;
            }
            // Sanación al final de cada turno si es posible
            p1.sanacion();
            p2.sanacion();
            turnos++;
        }

        if (p1.VerificarVitalidad() && p2.VerificarVitalidad()) {
            System.out.println("El enfrentamiento ha terminado en empate.");
        } else if (p1.VerificarVitalidad()) {
            System.out.println(p1.getNombre() + " ha ganado el enfrentamiento.");
        } else {
            System.out.println(p2.getNombre() + " ha ganado el enfrentamiento.");
        }
    }
}

