package com.tuempresa.labs.collections.Ejercicio7;

public class Main {
       // 7. En un banco, el sistema de atención al cliente debe manejar los turnos de manera ordenada.
    // Para lograrlo, se empleará una LinkedList (String), la cual permitirá agregar clientes en la
    // cola de espera, atender al primero en la lista y ofrecer una funcionalidad especial para
    // insertar clientes con urgencia al inicio de la cola sin afectar el rendimiento.
    static void main() {
        Banco banco = new Banco();

        // 1. Llegan clientes normales -> se agregan al final de la cola
        banco.agregarCliente("Ana");
        banco.agregarCliente("Luisa");
        banco.agregarCliente("Martaaa");
        IO.println(banco);                                   // [Ana, Luis, Marta]

        // 2. Se atiende al primero en la cola (FIFO)
        IO.println("Atendiendo a: " + banco.atenderCliente()); // Ana
        IO.println(banco);                                   // [Luis, Marta]

        // 3. Llega un cliente con urgencia -> se inserta al inicio en O(1)
        banco.agregarClienteUrgente("Pedro (urgente)");
        IO.println(banco);                                   // [Pedro (urgente), Luis, Marta]

        IO.println("Siguiente en la cola: " + banco.verSiguiente()); // Pedro (no lo retira)
        IO.println("Clientes en espera: " + banco.cantidadClientes()); // 3

        // 4. Validación: no se aceptan nombres vacíos
        IO.println("¿Se agregó un nombre vacío? " + banco.agregarCliente("   ")); // false

        // 5. Se atiende a todos hasta vaciar la cola
        while (!banco.estaVacia()) {
            IO.println("Atendiendo a: " + banco.atenderCliente());
        }

        // 6. Con la cola vacía, atender devuelve null en vez de lanzar una excepción
        IO.println("Atender con la cola vacía: " + banco.atenderCliente()); // null
    }
}

