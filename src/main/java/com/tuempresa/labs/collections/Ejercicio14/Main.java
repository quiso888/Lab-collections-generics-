package com.tuempresa.labs.collections.Ejercicio14;

public class Main {
    // 14. En una aplicación de mensajería, se requiere un historial de los últimos mensajes enviados.
    // Para lograrlo, se utilizará un ArrayDeque, que permitirá agregar nuevos mensajes al final de la
    // estructura y recuperar los últimos diez mensajes enviados de manera rápida y eficiente.
    static void main() {
        Chat chat = new Chat();

        // 1. Se envían mensajes -> cada uno se agrega al final
        chat.enviarMensaje("Hola");
        chat.enviarMensaje("¿Cómo estás?");
        chat.enviarMensaje("¿Vamos a clase?");
        IO.println(chat);            // [Hola, ¿Cómo estás?, ¿Vamos a clase?]
        IO.println("Último mensaje: " + chat.ultimoMensaje()); // ¿Vamos a clase?

        // 2. Se envían más mensajes hasta pasar de diez
        for (int i = 1; i <= 9; i++) {
            chat.enviarMensaje("Mensaje " + i);
        }

        // 3. Solo se guardan los últimos diez: "Hola" y "¿Cómo estás?" ya se borraron
        IO.println("Cantidad de mensajes: " + chat.cantidadMensajes()); // 10
        IO.println("Últimos 10 mensajes:");
        for (String mensaje : chat.getUltimosMensajes()) {
            IO.println("  " + mensaje);  // ¿Vamos a clase?, Mensaje 1, ..., Mensaje 9
        }

        // 4. Validación: no se envían mensajes vacíos
        IO.println("¿Se envió un mensaje vacío? " + chat.enviarMensaje("  ")); // false

        // 5. Sin mensajes, el último mensaje es null
        Chat vacio = new Chat();
        IO.println("Último mensaje (chat vacío): " + vacio.ultimoMensaje()); // null
    }
}