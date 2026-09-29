// Esta clase ordena una lista de elementos genéricos usando bubble sort, apoyándose
// en compareTo() (por eso T extends Comparable<T>). La dejo genérica para poder
// ordenar listas de Integer, String o cualquier tipo que sepa compararse a sí mismo.
package com.tuempresa.labs.generics.Avanzado;

import java.util.List;

public class Ordenador<T extends Comparable<T>> {

    public void ordenar(List<T> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {
                if (lista.get(j).compareTo(lista.get(j + 1)) > 0) {
                    T temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> numeros = new java.util.ArrayList<>(List.of(5, 2, 8, 1, 9));
        Ordenador<Integer> ordenador = new Ordenador<>();
        ordenador.ordenar(numeros);
        System.out.println("Ordenado: " + numeros);
    }
}
