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
public class AsesinoHumano extends Humano {
        public AsesinoHumano(String nombre, double fuerza, double vitalidad, int defensa, Arma arma) {
            super(nombre, "Asesino", fuerza, vitalidad, defensa, arma);
        }
        public void atacar(Personaje oponente) {
            double dañoAtaque =(Math.round(getFuerza()*getArma().calcularDanio(getFuerza())* 10.0) / 100.0);
            if (oponente instanceof MagoHumano) {
                dañoAtaque *= 0.5; // 50% de daño a Magos Humanos
            } else if (oponente instanceof MagoElfo || oponente instanceof MagoOrco || oponente instanceof GuerreroHumano) {
                dañoAtaque *= 0.4; // 40% de daño a Magos Elfos, Orcos y Guerreros Humanos
            } else if (oponente instanceof GuerreroElfo || oponente instanceof GuerreroOrco) {
                dañoAtaque *= 0.3; // 30% de daño a Guerreros Elfos y Orcos
            } else if (oponente instanceof AsesinoHumano) {
                dañoAtaque *= 0.2; // 20% de daño a otros Asesinos Humanos
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
