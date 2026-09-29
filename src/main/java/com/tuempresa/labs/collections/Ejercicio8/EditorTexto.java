package com.tuempresa.labs.collections.Ejercicio8;

import java.util.Vector;

/**
 * Editor de texto que guarda los cambios para poder deshacerlos.
 *
 * <p>Cada cambio (texto escrito) se guarda en un Vector. El último cambio
 * guardado es el primero que se deshace, como una pila.</p>
 *
 * <p>Se usa Vector porque es seguro cuando varios hilos lo usan al mismo
 * tiempo.</p>
 */
public class EditorTexto {

    /** Historial de cambios. El último elemento es el más reciente. */
    private Vector<String> historial;

    public EditorTexto() {
        historial = new Vector<>();
    }

    /**
     * Guarda un nuevo cambio al final del historial.
     *
     * @param texto texto que el usuario escribió.
     * @return true si se guardó, false si el texto es nulo o vacío.
     */
    public boolean escribir(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        return historial.add(texto);
    }

    /**
     * Deshace el último cambio: lo quita del historial y lo devuelve.
     *
     * @return el cambio deshecho, o null si no hay cambios.
     */
    public String deshacer() {
        // Se bloquea el historial para que otro hilo no lo cambie en medio
        synchronized (historial) {
            if (historial.isEmpty()) {
                return null;
            }
            return historial.remove(historial.size() - 1);
        }
    }

    /**
     * Muestra el último cambio sin quitarlo.
     *
     * @return el último cambio, o null si no hay cambios.
     */
    public String verUltimoCambio() {
        synchronized (historial) {
            if (historial.isEmpty()) {
                return null;
            }
            return historial.lastElement();
        }
    }

    /** @return el texto actual, uniendo todos los cambios en orden. */
    public String obtenerContenido() {
        synchronized (historial) {
            return String.join("", historial);
        }
    }

    /** @return cantidad de cambios en el historial. */
    public int cantidadCambios() {
        return historial.size();
    }

    /** @return true si hay algún cambio para deshacer. */
    public boolean puedeDeshacer() {
        return !historial.isEmpty();
    }

    /** @return una copia del historial, para que no se modifique desde afuera. */
    public Vector<String> getHistorial() {
        return new Vector<>(historial);
    }

    @Override
    public String toString() {
        return "Historial: " + historial + " -> Contenido: \"" + obtenerContenido() + "\"";
    }
}