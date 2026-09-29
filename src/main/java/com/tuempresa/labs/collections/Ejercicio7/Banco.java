package com.tuempresa.labs.collections.Ejercicio7;

import java.util.LinkedList;

/**
 * Sistema de turnos de atención al cliente de un banco.
 *
 * <p>Los clientes se guardan en una LinkedList que funciona como una cola:
 * el primero en llegar es el primero en ser atendido.</p>
 *
 * <p>Se usa LinkedList porque agregar o quitar clientes al inicio o al final
 * es rápido, sin tener que mover a los demás.</p>
 */
public class Banco {

    /** Cola de espera. El primer elemento es el próximo en ser atendido. */
    private LinkedList<String> turnos;

    public Banco() {
        turnos = new LinkedList<>();
    }

    /**
     * Agrega un cliente al final de la cola.
     *
     * @param nombreCliente nombre del cliente.
     * @return true si se agregó, false si el nombre es nulo o vacío.
     */
    public boolean agregarCliente(String nombreCliente) {
        if (!esNombreValido(nombreCliente)) {
            return false;
        }
        turnos.addLast(nombreCliente);
        return true;
    }

    /**
     * Agrega un cliente urgente al inicio de la cola, para que sea el
     * siguiente en ser atendido.
     *
     * @param nombreCliente nombre del cliente urgente.
     * @return true si se agregó, false si el nombre es nulo o vacío.
     */
    public boolean agregarClienteUrgente(String nombreCliente) {
        if (!esNombreValido(nombreCliente)) {
            return false;
        }
        turnos.addFirst(nombreCliente);
        return true;
    }

    /**
     * Atiende al primer cliente: lo quita de la cola y lo devuelve.
     *
     * @return el nombre del cliente atendido, o null si la cola está vacía.
     */
    public String atenderCliente() {
        return turnos.pollFirst();
    }

    /**
     * Muestra el siguiente cliente sin quitarlo de la cola.
     *
     * @return el nombre del siguiente cliente, o null si la cola está vacía.
     */
    public String verSiguiente() {
        return turnos.peekFirst();
    }

    /** @return cantidad de clientes en espera. */
    public int cantidadClientes() {
        return turnos.size();
    }

    /** @return true si no hay clientes en espera. */
    public boolean estaVacia() {
        return turnos.isEmpty();
    }

    /** @return una copia de la cola, para que no se modifique desde afuera. */
    public LinkedList<String> getTurnos() {
        return new LinkedList<>(turnos);
    }

    private boolean esNombreValido(String nombreCliente) {
        return nombreCliente != null && !nombreCliente.isBlank();
    }

    @Override
    public String toString() {
        return "Cola de turnos: " + turnos;
    }
}