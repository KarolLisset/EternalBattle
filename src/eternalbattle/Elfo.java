/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eternalbattle;

/**
 *
 * @author KarolMascorro
 */
public class Elfo extends Personaje {
        public Elfo(String nombre, String subtipo, double fuerza, double vitalidad, int defensa, Arma arma) {
            this.nombre = nombre;
            this.raza = "Elfo"; // Establecer la raza del personaje
            this.subtipo = subtipo; // Establecer el subtipo del personaje
            this.fuerza = fuerza; // Establecer la fuerza del personaje
            this.vitalidad = vitalidad; // Establecer la vitalidad del personaje
            this.defensa = defensa; // Establecer la defensa del personaje
            this.arma = arma; // Establecer el arma del personaje
        }

        public void sanacion() {
            if(vitalidad<50){
             vitalidad=vitalidad +4;
                System.out.println(nombre+" se ha regenerado con 4");
                System.out.println("Vitalidad actual: "+Math.round(getVitalidad() * 100.0) / 100.0);
            }
        }
    }