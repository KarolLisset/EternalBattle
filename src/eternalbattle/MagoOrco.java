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
public class MagoOrco extends Orco {
        public MagoOrco(String nombre, double fuerza, double vitalidad, int defensa, Arma arma) {
            super(nombre, "Mago", fuerza, vitalidad, defensa, arma);
        }
        public void atacar(Personaje oponente) {
            double dañoAtaque =(Math.round(getFuerza()*getArma().calcularDanio(getFuerza())* 10.0) / 100.0);
            if (oponente instanceof GuerreroOrco) {
                dañoAtaque *= 0.6; // 60% de daño a Guerreros Orcos
            } else if (oponente instanceof GuerreroElfo || oponente instanceof GuerreroHumano) {
                dañoAtaque *= 0.5; // 50% de daño a Guerreros Elfos y Humanos
            } else if (oponente instanceof AsesinoOrco || oponente instanceof AsesinoHumano || oponente instanceof AsesinoElfo) {
                dañoAtaque *= 0.4; // 40% de daño a Asesinos
            } else if (oponente instanceof MagoOrco || oponente instanceof MagoHumano || oponente instanceof MagoElfo) {
                dañoAtaque *= 0.3; // 30% de daño a otros Magos
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

        public void sanacion() {
            if(vitalidad<50){
             vitalidad=vitalidad +6;
                System.out.println(nombre+" se ha regenerado con 6 ");
                System.out.println("Vitalidad nueva: "+Math.round(getVitalidad() * 100.0) / 100.0);
            }
        }
    }
