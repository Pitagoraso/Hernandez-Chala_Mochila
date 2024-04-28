//Desarrolla un programa en java q permita seleccionar una serie de objetos al ser incluidos en la mochila
//Restriccion: Cada objeto tendra las siguiente caracteristicas el nombre, forma, peso, Precio
//En la mochila solo tiene una capacidad limitada de peso (este peso se debe ingresar)y al mismo tiempo se busca maximizar el valor total q contiene la mochila
//Numero minimo a objetos seleccionar 15
//Hernandez Chala Mike Jhoan
package javaapplication80;

import java.util.Scanner;
class Objeto {
    String nombre;
    String forma;
    double peso;
    double precio;
    public Objeto(String nombre, String forma, double peso, double precio) {
        this.nombre = nombre;
        this.forma = forma;
        this.peso = peso;
        this.precio = precio;
    }
    public double getPrecioPorPeso() {
        return precio / peso;
    }
}
public class Mochila {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Objeto[] objetos = {
            new Objeto("A", "A1", 1.5, 1500),
            new Objeto("B", "B1", 0.5, 20),
            new Objeto("C", "C1", 0.9, 3),
            new Objeto("D", "D1", 0.6, 800),
            new Objeto("E", "E1", 0.4, 500),
            new Objeto("F", "F1", 0.3, 25),
            new Objeto("G", "G1", 0.8, 120),
            new Objeto("H", "H1", 0.7, 30),
            new Objeto("I", "I1", 2.5, 70),
            new Objeto("J", "J1", 4.5, 250),
            new Objeto("K", "K1", 1.0, 60),
            new Objeto("L", "L1", 2.0, 25),
            new Objeto("M", "M1", 0.1, 5),
            new Objeto("N", "N1", 0.2, 40),
            new Objeto("Ñ", "Ñ1", 2.0, 100),
            new Objeto("O", "O1", 1.2, 150),
            new Objeto("P", "P1", 0.5, 35),
            new Objeto("Q", "Q1", 3.0, 50)
        };
        System.out.println("Ingrese la capacidad máxima de la mochila en kilogramos:");
        double capacidadMochila = scanner.nextDouble();
        for (int i = 0; i < objetos.length - 1; i++) {
            for (int j = i + 1; j < objetos.length; j++) {
                if (objetos[i].getPrecioPorPeso() < objetos[j].getPrecioPorPeso()) {
                    Objeto temp = objetos[i];
                    objetos[i] = objetos[j];
                    objetos[j] = temp;
                }
            }
        }
        double pesoActual = 0.0;
        double valorTotal = 0.0;
        int count = 0;
        for (int i = 0; i < objetos.length && count < 15; i++) {
            if (pesoActual + objetos[i].peso <= capacidadMochila) {
                pesoActual += objetos[i].peso;
                valorTotal += objetos[i].precio;
                System.out.println("Objeto seleccionado: " + objetos[i].nombre + " (Peso: " + objetos[i].peso + " kg, Precio: $" + objetos[i].precio + ")");
                count++;
            }
        }
        if (count < 15) {
            System.out.println("No fue posible seleccionar 15 objetos sin exceder el peso máximo de la mochila.");
        }
        System.out.println("Peso total de la mochila: " + pesoActual + " kg");
        System.out.println("Valor total de la mochila: $" + valorTotal);
    }
}
