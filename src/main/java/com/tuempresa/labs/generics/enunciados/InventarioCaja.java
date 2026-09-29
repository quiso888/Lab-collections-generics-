// Esta clase guarda elementos comparables en una lista y tiene un método que filtra
// los que son mayores a un umbral dado. La restricción es que solo puedo recorrer
// la lista con Iterator (nada de for-each), para practicar el manejo manual del iterador.
package com.tuempresa.labs.generics.enunciados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventarioCaja<T extends Comparable<T>> {

    private List<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public List<T> mayoresQue(T umbral) {
        List<T> resultado = new ArrayList<>();
        Iterator<T> it = elementos.iterator();
        while (it.hasNext()) {
            T actual = it.next();
            if (actual.compareTo(umbral) > 0) {
                resultado.add(actual);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        InventarioCaja<Integer> inventario = new InventarioCaja<>();
        inventario.agregar(10);
        inventario.agregar(25);
        inventario.agregar(5);
        inventario.agregar(30);

        System.out.println("Mayores que 15: " + inventario.mayoresQue(15));
    }
}
