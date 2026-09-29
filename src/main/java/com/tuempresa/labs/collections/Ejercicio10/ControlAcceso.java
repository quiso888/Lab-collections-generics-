package com.tuempresa.labs.collections.Ejercicio10;

import java.util.HashSet;

/**
 * Control de acceso de un edificio por código de empleado.
 *
 * <p>Los códigos se guardan en un HashSet, que no permite duplicados y
 * busca un código de forma rápida.</p>
 */
public class ControlAcceso {

    /** Códigos de los empleados autorizados. */
    private HashSet<String> empleados;

    public ControlAcceso() {
        empleados = new HashSet<>();
    }

    /**
     * Registra el código de un empleado.
     *
     * @param id código del empleado.
     * @return true si se registró, false si el código es nulo, vacío o ya existe.
     */
    public boolean registrarEmpleado(String id) {
        if (id == null || id.isBlank()) {
            return false;
        }
        return empleados.add(id);
    }

    /**
     * Verifica si un empleado puede entrar al edificio.
     *
     * @param id código del empleado.
     * @return true si el código está registrado.
     */
    public boolean permitirEntrada(String id) {
        return empleados.contains(id);
    }

    /**
     * Elimina el código de un empleado (por ejemplo, si ya no trabaja ahí).
     *
     * @param id código del empleado.
     * @return true si se eliminó, false si no estaba registrado.
     */
    public boolean eliminarEmpleado(String id) {
        return empleados.remove(id);
    }

    /** @return cantidad de empleados registrados. */
    public int cantidadEmpleados() {
        return empleados.size();
    }

    /** @return una copia de los códigos, para que no se modifiquen desde afuera. */
    public HashSet<String> getEmpleados() {
        return new HashSet<>(empleados);
    }

    @Override
    public String toString() {
        return "Empleados registrados: " + empleados;
    }
}
