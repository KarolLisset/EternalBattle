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
public class Arma {
        public String nombre; // Agregado nombre del arma
        public double danioBase; // Agregado daÃ±o base del arma

        public Arma(String nombre, double daniobase) {
            this.nombre = nombre;
            
            this.danioBase = (Math.random() * 6)+1; 
                    
        }

        public String getNombre() { // Agregado getter para el nombre del arma
            return nombre;
        }

        public double calcularDanio(double fuerza) {
            return fuerza * danioBase;
        }
    }

