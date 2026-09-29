// Implemento una pila genérica sobre LinkedList. El método extraerSi() recorre
// la pila con Iterator (sin modificarla) y arma una lista aparte con los elementos
// que cumplan una condición (Predicate), hasta un máximo indicado.
package com.tuempresa.labs.generics.enunciados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class PilaGenerica<T> {

    private LinkedList<T> pila = new LinkedList<>();

    public void push(T elemento) {
        pila.addFirst(elemento);
    }

    public T pop() {
        return pila.removeFirst();
    }

    public List<T> extraerSi(Predicate<T> p, int max) {
        List<T> resultado = new ArrayList<>();
        Iterator<T> it = pila.iterator();
        while (it.hasNext() && resultado.size() < max) {
            T actual = it.next();
            if (p.test(actual)) {
                resultado.add(actual);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        PilaGenerica<Integer> pila = new PilaGenerica<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        List<Integer> pares = pila.extraerSi(n -> n % 2 == 0, 2);
        System.out.println("Pares extraídos (máx 2): " + pares);
    }
}
