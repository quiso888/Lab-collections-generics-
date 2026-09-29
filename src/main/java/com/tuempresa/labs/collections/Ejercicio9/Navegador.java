package com.tuempresa.labs.collections.Ejercicio9;

import java.util.Stack;

/**
 * Navegador web que permite volver a las páginas anteriores.
 *
 * <p>Las páginas visitadas se guardan en un Stack (pila). La página de arriba
 * es la actual; al retroceder se quita y queda la anterior.</p>
 */
public class Navegador {

    /** Páginas visitadas. La de arriba es la página actual. */
    private Stack<String> historial;

    public Navegador() {
        historial = new Stack<>();
    }

    /**
     * Visita una nueva página y la pone encima de la pila.
     *
     * @param pagina dirección de la página.
     * @return true si se visitó, false si la dirección es nula o vacía.
     */
    public boolean visitar(String pagina) {
        if (pagina == null || pagina.isBlank()) {
            return false;
        }
        historial.push(pagina);
        return true;
    }

    /**
     * Vuelve a la página anterior quitando la actual de la pila.
     *
     * @return la página a la que se regresó, o null si no hay página anterior.
     */
    public String retroceder() {
        if (!puedeRetroceder()) {
            return null;
        }
        historial.pop();
        return historial.peek();
    }

    /** @return la página actual, o null si no se ha visitado ninguna. */
    public String paginaActual() {
        if (historial.isEmpty()) {
            return null;
        }
        return historial.peek();
    }

    /** @return true si hay una página anterior a la cual volver. */
    public boolean puedeRetroceder() {
        return historial.size() > 1;
    }

    /** @return cantidad de páginas en el historial. */
    public int cantidadPaginas() {
        return historial.size();
    }

    /** @return una copia del historial, para que no se modifique desde afuera. */
    public Stack<String> getHistorial() {
        Stack<String> copia = new Stack<>();
        copia.addAll(historial);
        return copia;
    }

    @Override
    public String toString() {
        return "Historial: " + historial + " -> Actual: " + paginaActual();
    }
}