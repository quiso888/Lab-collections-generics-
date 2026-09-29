package com.tuempresa.labs.collections.Ejercicio11;

import java.util.LinkedHashSet;

/**
 * Lista de canciones favoritas de una aplicación de música.
 *
 * <p>Las canciones se guardan en un LinkedHashSet, que no permite duplicados
 * y conserva el orden en que se agregaron.</p>
 */
public class ListaFavoritos {

    /** Canciones favoritas, en el orden en que se agregaron. */
    private LinkedHashSet<String> canciones;

    public ListaFavoritos() {
        canciones = new LinkedHashSet<>();
    }

    /**
     * Marca una canción como favorita.
     *
     * @param cancion nombre de la canción.
     * @return true si se agregó, false si el nombre es nulo, vacío o ya es favorita.
     */
    public boolean agregarFavorita(String cancion) {
        if (cancion == null || cancion.isBlank()) {
            return false;
        }
        return canciones.add(cancion);
    }

    /**
     * Quita una canción de favoritas.
     *
     * @param cancion nombre de la canción.
     * @return true si se quitó, false si no era favorita.
     */
    public boolean quitarFavorita(String cancion) {
        return canciones.remove(cancion);
    }

    /** @return true si la canción está marcada como favorita. */
    public boolean esFavorita(String cancion) {
        return canciones.contains(cancion);
    }

    /** @return cantidad de canciones favoritas. */
    public int cantidadFavoritas() {
        return canciones.size();
    }

    /** @return una copia de las favoritas, para que no se modifiquen desde afuera. */
    public LinkedHashSet<String> getCanciones() {
        return new LinkedHashSet<>(canciones);
    }

    @Override
    public String toString() {
        return "Favoritas: " + canciones;
    }
}
