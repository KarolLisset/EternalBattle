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
public class Personaje {
        protected String nombre;
        protected String raza;
        protected String subtipo;
        protected double fuerza;
        protected double vitalidad;
        protected int defensa;
        protected Arma arma;

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setRaza(String raza) {
            this.raza = raza;
        }

        public void setSubtipo(String subtipo) {
            this.subtipo = subtipo;
        }

        public void setFuerza(double fuerza) {
            this.fuerza = fuerza;
        }

        public void setVitalidad(double vitalidad) {
            this.vitalidad = vitalidad;
        }

        public void setDefensa(int defensa) {
            this.defensa = defensa;
            
        }

        public void setArma(Arma arma) {
            this.arma = arma;
        }

        public String getNombre() {
            return nombre;
        }

        public String getRaza() {
            return raza;
        }

        public String getSubtipo() {
            return subtipo;
        }

        public double getFuerza() {
            return fuerza;
        }

        public double getVitalidad() {
            return vitalidad;
        }

        public int getDefensa() {
            return defensa;
            
        }

        public Arma getArma() {
            return arma;
        }

        public void mostrarPersonaje() {
            System.out.println("Nombre: " + getNombre());
            System.out.println("Es un " + getRaza());
            System.out.println("De tipo " + getSubtipo());
            System.out.println("Tiene una fuerza de " + getFuerza());
            System.out.println("Tiene una vitalidad de " + getVitalidad());
            System.out.println("Su defensa es de " + getDefensa());
            System.out.println("Carga consigo " + getArma().getNombre()); // Acceso al nombre del arma
            System.out.println("Daño base del arma: " + Math.round(getArma().calcularDanio(getFuerza()) * 10.0) / 100.0);
            System.out.println("Daño de ataque: " + Math.round(getFuerza()*getArma().calcularDanio(getFuerza())* 10.0) / 100.0);
 // Acceso al nombre del arma
        }

        public boolean VerificarVitalidad() {
            return vitalidad > 0;
        }

        public void mostrarVitalidad() {
            System.out.println("Vitalidad del personaje atacado: " + Math.round(getVitalidad() * 100.0) / 100.0);
        }

        public void sanacion() {
            // Implementar lógica de sanación 
        }

        public void atacar(Personaje oponente) {
            

          
        }
    }
