// Esta clase envuelve un ArrayList e implementa Iterable<T> para poder recorrerla
// con for-each de forma normal, pero además incluye un iterador inverso propio
// (clase interna) que recorre del último elemento al primero. Con ese iterador
// inverso armo el método rango(), que devuelve los elementos entre min y max.
package com.tuempresa.labs.generics.enunciados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaTareas<T extends Comparable<T>> implements Iterable<T> {

    private List<T> tareas = new ArrayList<>();

    public void agregar(T tarea) {
        tareas.add(tarea);
    }

    @Override
    public Iterator<T> iterator() {
        return tareas.iterator();
    }

    public Iterator<T> iteradorInverso() {
        return new IteradorInverso();
    }

    public List<T> rango(T min, T max) {
        List<T> resultado = new ArrayList<>();
        Iterator<T> it = iteradorInverso();
        while (it.hasNext()) {
            T actual = it.next();
            if (actual.compareTo(min) >= 0 && actual.compareTo(max) <= 0) {
                resultado.add(actual);
            }
        }
        return resultado;
    }

    private class IteradorInverso implements Iterator<T> {
        private int indice = tareas.size() - 1;

        @Override
        public boolean hasNext() {
            return indice >= 0;
        }

        @Override
        public T next() {
            return tareas.get(indice--);
        }
    }

    public static void main(String[] args) {
        ListaTareas<Integer> lista = new ListaTareas<>();
        lista.agregar(1);
        lista.agregar(5);
        lista.agregar(10);
        lista.agregar(15);
        lista.agregar(20);

        System.out.println("Recorrido normal:");
        for (Integer t : lista) {
            System.out.println(t);
        }

        System.out.println("Rango [5, 15] con iterador inverso: " + lista.rango(5, 15));
    }
}
