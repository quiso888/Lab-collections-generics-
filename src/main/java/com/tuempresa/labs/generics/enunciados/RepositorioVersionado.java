// Esta clase simula un repositorio con historial de elementos. snapshot() saca una
// copia de todo usando solo Iterator, y diff() compara dos repositorios y devuelve
// lo que está en uno pero no en el otro, también recorriendo solo con iteradores
// (sin usar Set ni streams, tal como pide el enunciado).
package com.tuempresa.labs.generics.enunciados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RepositorioVersionado<T extends Comparable<T>> {

    private LinkedList<T> elementos = new LinkedList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public List<T> snapshot() {
        List<T> copia = new ArrayList<>();
        Iterator<T> it = elementos.iterator();
        while (it.hasNext()) {
            copia.add(it.next());
        }
        return copia;
    }

    public List<T> diff(RepositorioVersionado<T> otro) {
        List<T> resultado = new ArrayList<>();
        Iterator<T> itPropio = elementos.iterator();

        while (itPropio.hasNext()) {
            T actual = itPropio.next();
            boolean encontrado = false;

            Iterator<T> itOtro = otro.elementos.iterator();
            while (itOtro.hasNext()) {
                if (itOtro.next().compareTo(actual) == 0) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                resultado.add(actual);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        RepositorioVersionado<Integer> repoActual = new RepositorioVersionado<>();
        repoActual.agregar(1);
        repoActual.agregar(2);
        repoActual.agregar(3);

        RepositorioVersionado<Integer> repoAnterior = new RepositorioVersionado<>();
        repoAnterior.agregar(2);
        repoAnterior.agregar(3);

        System.out.println("Snapshot actual: " + repoActual.snapshot());
        System.out.println("Diferencia (actual - anterior): " + repoActual.diff(repoAnterior));
    }
}
