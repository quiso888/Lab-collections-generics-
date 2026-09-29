// Con esta clase practico la restricción "T extends Comparable<T>", que obliga a que
// el tipo que se use tenga el método compareTo(). Así puedo comparar dos elementos
// cualquiera (números, texto, etc.) y devolver el mayor sin importar el tipo exacto.
package com.tuempresa.labs.generics.medio;

public class Comparador<T extends Comparable<T>> {

    public T mayor(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static void main(String[] args) {
        Comparador<Integer> compEnteros = new Comparador<>();
        System.out.println("Mayor: " + compEnteros.mayor(15, 27));

        Comparador<String> compTexto = new Comparador<>();
        System.out.println("Mayor: " + compTexto.mayor("manzana", "banana"));
    }
}
