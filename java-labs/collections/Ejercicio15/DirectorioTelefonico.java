package Ejercicio15;

import java.util.HashMap;

/**
 * Directorio telefónico que asocia cada nombre con su número.
 *
 * <p>Los contactos se guardan en un HashMap (nombre -> número), que permite
 * buscar un número rápido por nombre y no admite nombres repetidos.</p>
 */
public class DirectorioTelefonico {

    /** Contactos: la llave es el nombre y el valor es el número. */
    private HashMap<String, String> contactos;

    public DirectorioTelefonico() {
        contactos = new HashMap<>();
    }

    /**
     * Agrega un contacto nuevo.
     *
     * @param nombre nombre del contacto.
     * @param numero número de teléfono.
     * @return true si se agregó, false si hay datos vacíos o el nombre ya existe.
     */
    public boolean agregarContacto(String nombre, String numero) {
        if (!esValido(nombre) || !esValido(numero)) {
            return false;
        }
        return contactos.putIfAbsent(nombre, numero) == null;
    }

    /**
     * Busca el número de un contacto.
     *
     * @param nombre nombre del contacto.
     * @return el número, o null si el contacto no existe.
     */
    public String buscarNumero(String nombre) {
        return contactos.get(nombre);
    }

    /**
     * Cambia el número de un contacto que ya existe.
     *
     * @param nombre      nombre del contacto.
     * @param nuevoNumero nuevo número de teléfono.
     * @return true si se actualizó, false si el número es vacío o el contacto no existe.
     */
    public boolean actualizarNumero(String nombre, String nuevoNumero) {
        if (!esValido(nuevoNumero)) {
            return false;
        }
        return contactos.replace(nombre, nuevoNumero) != null;
    }

    /**
     * Elimina un contacto.
     *
     * @param nombre nombre del contacto.
     * @return true si se eliminó, false si no existía.
     */
    public boolean eliminarContacto(String nombre) {
        return contactos.remove(nombre) != null;
    }

    /** @return true si el contacto existe. */
    public boolean existeContacto(String nombre) {
        return contactos.containsKey(nombre);
    }

    /** @return cantidad de contactos. */
    public int cantidadContactos() {
        return contactos.size();
    }

    /** @return una copia de los contactos, para que no se modifiquen desde afuera. */
    public HashMap<String, String> getContactos() {
        return new HashMap<>(contactos);
    }

    private boolean esValido(String texto) {
        return texto != null && !texto.isBlank();
    }

    @Override
    public String toString() {
        return "Directorio: " + contactos;
    }
}

