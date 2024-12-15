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
    public class MagoElfo extends Elfo {
        public MagoElfo(String nombre, double fuerza, double vitalidad, int defensa, Arma arma) {
            super(nombre, "Mago", fuerza, vitalidad, defensa, arma);
        }
        @Override
        public void atacar(Personaje oponente) {
            double dañoAtaque =(Math.round(getFuerza()*getArma().calcularDanio(getFuerza())* 10.0) / 100.0);
            if (oponente instanceof GuerreroElfo || oponente instanceof GuerreroHumano || oponente instanceof GuerreroOrco) {
                dañoAtaque *= 0.5; // 50% de daño a Guerreros
            } else if (oponente instanceof AsesinoElfo) {
                dañoAtaque *= 0.4; // 40% de daño a Asesinos Elfos
            } else if (oponente instanceof AsesinoHumano || oponente instanceof AsesinoOrco) {
                dañoAtaque *= 0.3; // 30% de daño a Asesinos Humanos y Orcos
            } else if (oponente instanceof MagoElfo || oponente instanceof MagoHumano || oponente instanceof MagoOrco) {
                dañoAtaque *= 0.2; // 20% de daño a otros Magos
            }
            dañoAtaque -= oponente.getDefensa();
    // Asegurarse de que el daño no sea negativo
            dañoAtaque = Math.max(0, dañoAtaque);
    // Reducir la vitalidad del oponente
            System.out.println("***************");
            oponente.vitalidad -= dañoAtaque;
            System.out.println(oponente.nombre + " Ha recibido un daño de " + Math.round(dañoAtaque * 100.0) / 100.0);
            oponente.mostrarVitalidad();
            System.out.println("***************");
        }
        @Override
        public void sanacion() {
           if(vitalidad<50){
             vitalidad=vitalidad +10;
                System.out.println(nombre+" se ha regenerado con 10");
                System.out.println("Vitalidad nueva: "+Math.round(getVitalidad() * 100.0) / 100.0);
        }
    }
    }
