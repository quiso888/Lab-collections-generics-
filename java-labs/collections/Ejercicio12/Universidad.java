package Ejercicio12;

import java.util.TreeSet;

/**
 * Registro de estudiantes de una universidad, ordenados alfabéticamente.
 *
 * <p>Los nombres se guardan en un TreeSet, que los mantiene ordenados
 * automáticamente y no permite duplicados.</p>
 */
public class Universidad {

    /** Nombres de los estudiantes, ordenados de la A a la Z. */
    private TreeSet<String> estudiantes;

    public Universidad() {
        // Se ignoran mayúsculas y minúsculas al ordenar ("ana" y "Ana" van juntos)
        estudiantes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Agrega un estudiante; queda en su lugar alfabético.
     *
     * @param nombre nombre del estudiante.
     * @return true si se agregó, false si el nombre es nulo, vacío o ya existe.
     */
    public boolean agregarEstudiante(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return false;
        }
        return estudiantes.add(nombre);
    }

    /** @return el primer nombre en orden alfabético, o null si no hay estudiantes. */
    public String primerEstudiante() {
        if (estudiantes.isEmpty()) {
            return null;
        }
        return estudiantes.first();
    }

    /** @return el último nombre en orden alfabético, o null si no hay estudiantes. */
    public String ultimoEstudiante() {
        if (estudiantes.isEmpty()) {
            return null;
        }
        return estudiantes.last();
    }

    /** @return true si el estudiante está registrado. */
    public boolean buscarEstudiante(String nombre) {
        return estudiantes.contains(nombre);
    }

    /** @return cantidad de estudiantes registrados. */
    public int cantidadEstudiantes() {
        return estudiantes.size();
    }

    /** @return una copia de los estudiantes, para que no se modifiquen desde afuera. */
    public TreeSet<String> getEstudiantes() {
        return new TreeSet<>(estudiantes);
    }

    @Override
    public String toString() {
        return "Estudiantes: " + estudiantes;
    }
}

