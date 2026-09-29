package com.tuempresa.labs.collections.Ejercicio14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Historial de los últimos mensajes enviados en una aplicación de mensajería.
 *
 * <p>Los mensajes se guardan en un ArrayDeque: los nuevos entran por el final
 * y, cuando hay más de diez, se borra el más antiguo del inicio.</p>
 */
public class Chat {

    public static final int MAX_MENSAJES = 10;

    /** Mensajes enviados. El primero es el más antiguo y el último el más reciente. */
    private ArrayDeque<String> mensajes;

    public Chat() {
        mensajes = new ArrayDeque<>();
    }

    /**
     * Envía un mensaje y lo agrega al final del historial.
     * Si ya hay diez mensajes, se borra el más antiguo.
     *
     * @param mensaje texto del mensaje.
     * @return true si se envió, false si el mensaje es nulo o vacío.
     */
    public boolean enviarMensaje(String mensaje) {
        if (mensaje == null || mensaje.isBlank()) {
            return false;
        }
        mensajes.addLast(mensaje);
        if (mensajes.size() > MAX_MENSAJES) {
            mensajes.pollFirst();
        }
        return true;
    }

    /** @return los últimos mensajes enviados, del más antiguo al más reciente. */
    public List<String> getUltimosMensajes() {
        return new ArrayList<>(mensajes);
    }

    /** @return el último mensaje enviado, o null si no hay mensajes. */
    public String ultimoMensaje() {
        return mensajes.peekLast();
    }

    /** @return cantidad de mensajes en el historial. */
    public int cantidadMensajes() {
        return mensajes.size();
    }

    @Override
    public String toString() {
        return "Historial: " + mensajes;
    }
}
