// Esta clase guarda dos valores del mismo tipo genérico T y compara si son iguales.
// La idea es practicar cómo se usa equals() de forma genérica sin saber de antemano
// qué tipo de dato va a recibir (puede ser String, Integer, lo que sea).
package com.tuempresa.labs.generics.basico;

public class Par<T> {

    private T primero;
    private T segundo;

    public Par(T primero, T segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public boolean sonIguales() {
        if (primero == null) {
            return segundo == null;
        }
        return primero.equals(segundo);
    }

    public static void main(String[] args) {
        Par<Integer> par1 = new Par<>(5, 5);
        System.out.println("¿Son iguales? " + par1.sonIguales());

        Par<String> par2 = new Par<>("Java", "Kotlin");
        System.out.println("¿Son iguales? " + par2.sonIguales());
    }
}
