package com.tuempresa.labs.collections.Ejercicio13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Sala de urgencias de un hospital que atiende según la gravedad.
 *
 * <p>Los pacientes se guardan en una PriorityQueue, que siempre deja de
 * primero al más urgente. Si dos tienen la misma prioridad, se atiende
 * primero al que llegó antes.</p>
 */
public class Hospital {

    public static final int PRIORIDAD_MAXIMA = 1;
    public static final int PRIORIDAD_MINIMA = 5;

    /** Pacientes en espera. El primero es el más urgente. */
    private PriorityQueue<Paciente> pacientes;
    /** Cuenta las llegadas para saber quién llegó primero. */
    private int contadorLlegadas;

    public Hospital() {
        pacientes = new PriorityQueue<>(
                Comparator.comparingInt(Paciente::getPrioridad)
                        .thenComparingInt(Paciente::getLlegada));
        contadorLlegadas = 0;
    }

    /**
     * Ingresa un paciente con su nivel de prioridad.
     *
     * @param nombre    nombre del paciente.
     * @param prioridad de 1 (más urgente) a 5 (menos urgente).
     * @return true si se ingresó, false si el nombre es vacío o la prioridad no es válida.
     */
    public boolean ingresarPaciente(String nombre, int prioridad) {
        if (nombre == null || nombre.isBlank()) {
            return false;
        }
        if (prioridad < PRIORIDAD_MAXIMA || prioridad > PRIORIDAD_MINIMA) {
            return false;
        }
        contadorLlegadas++;
        return pacientes.add(new Paciente(nombre, prioridad, contadorLlegadas));
    }

    /**
     * Atiende al paciente más urgente: lo quita de la espera y lo devuelve.
     *
     * @return el paciente atendido, o null si no hay pacientes.
     */
    public Paciente atenderPaciente() {
        return pacientes.poll();
    }

    /** @return el siguiente paciente a atender sin quitarlo, o null si no hay pacientes. */
    public Paciente verSiguiente() {
        return pacientes.peek();
    }

    /** @return cantidad de pacientes en espera. */
    public int cantidadPacientes() {
        return pacientes.size();
    }

    /** @return true si no hay pacientes en espera. */
    public boolean estaVacia() {
        return pacientes.isEmpty();
    }

    /** @return los pacientes en el orden en que serán atendidos. */
    public List<Paciente> getPacientesEnOrden() {
        List<Paciente> lista = new ArrayList<>(pacientes);
        lista.sort(pacientes.comparator());
        return lista;
    }

    @Override
    public String toString() {
        return "Pacientes en espera: " + getPacientesEnOrden();
    }
}
