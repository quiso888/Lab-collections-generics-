package Ejercicio13;

/**
 * Paciente del hospital con su nivel de prioridad.
 *
 * <p>La prioridad va de 1 (más urgente) a 5 (menos urgente).</p>
 */
public class Paciente {

    private String nombre;
    private int prioridad;
    /** Orden en que llegó al hospital; desempata pacientes con la misma prioridad. */
    private int llegada;

    public Paciente(String nombre, int prioridad, int llegada) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.llegada = llegada;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getLlegada() {
        return llegada;
    }

    @Override
    public String toString() {
        return nombre + " (prioridad " + prioridad + ")";
    }
}
