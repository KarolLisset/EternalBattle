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
 public class AsesinoElfo extends Elfo {
        public AsesinoElfo(String nombre, double fuerza, double vitalidad, int defensa, Arma arma) {
            super(nombre, "Asesino", fuerza, vitalidad, defensa, arma);
        }
        public void atacar(Personaje oponente) {
            double dañoAtaque =(Math.round(getFuerza()*getArma().calcularDanio(getFuerza())* 10.0) / 100.0);
            if (oponente instanceof MagoElfo) {
                dañoAtaque *= 0.5; // 50% de daño a Magos Elfos
            } else if (oponente instanceof MagoHumano || oponente instanceof MagoOrco || oponente instanceof GuerreroElfo) {
                dañoAtaque *= 0.4; // 40% de daño a Magos Humanos, Orcos y Guerreros Elfos
            } else if (oponente instanceof GuerreroHumano || oponente instanceof AsesinoOrco) {
                dañoAtaque *= 0.3; // 30% de daño a Guerreros Humanos y Asesinos Orcos
            } else if (oponente instanceof AsesinoElfo) {
                dañoAtaque *= 0.2; // 20% de daño a otros Asesinos Elfos
            }
            dañoAtaque -= oponente.getDefensa();
    // Asegurarse de que el daño no sea negativo
            dañoAtaque = Math.max(0, dañoAtaque);
    // Reducir la vitalidad del oponente
            System.out.println("***************");
            oponente.vitalidad -= dañoAtaque;
            System.out.println(oponente.nombre + " Ha recibido un daño de " +Math.round(dañoAtaque * 100.0) / 100.0);
            oponente.mostrarVitalidad();
            System.out.println("***************");
        }
    }