package com.tuempresa.labs.collections.Ejercicio13;

public class Main {
    // 13. En un hospital, los pacientes deben ser atendidos según la gravedad de su condición, con
    // los más urgentes siendo tratados primero. Para manejar esto, se implementará una PriorityQueue,
    // donde cada paciente será ingresado con un nivel de prioridad y el sistema garantizará que
    // aquellos con mayor urgencia sean atendidos antes que los demás.
    static void main() {
        Hospital hospital = new Hospital();

        // 1. Llegan pacientes con distinta prioridad (1 = más urgente, 5 = menos urgente)
        hospital.ingresarPaciente("Ana", 3);
        hospital.ingresarPaciente("Luis", 5);
        hospital.ingresarPaciente("Marta", 1);
        hospital.ingresarPaciente("Jorge", 3);
        IO.println(hospital);        // [Marta (prioridad 1), Ana (prioridad 3), Jorge (prioridad 3), Luis (prioridad 5)]

        // 2. Se atiende primero al más urgente, sin importar el orden de llegada
        IO.println("Atendiendo a: " + hospital.atenderPaciente()); // Marta (prioridad 1)

        // 3. Llega un paciente muy grave -> pasa de primero
        hospital.ingresarPaciente("Pedro", 1);
        IO.println("Siguiente: " + hospital.verSiguiente());      // Pedro (prioridad 1)
        IO.println("Cantidad de pacientes: " + hospital.cantidadPacientes()); // 4

        // 4. Validación: prioridad fuera de rango o nombre vacío
        IO.println("¿Se ingresó con prioridad 9? " + hospital.ingresarPaciente("Sofía", 9)); // false
        IO.println("¿Se ingresó sin nombre? " + hospital.ingresarPaciente("  ", 2));         // false

        // 5. Se atiende a todos. Ana y Jorge tienen la misma prioridad: va primero quien llegó antes
        while (!hospital.estaVacia()) {
            IO.println("Atendiendo a: " + hospital.atenderPaciente());
        }
        // Pedro (1), Ana (3), Jorge (3), Luis (5)

        // 6. Sin pacientes, atender devuelve null en vez de lanzar una excepción
        IO.println("Atender sin pacientes: " + hospital.atenderPaciente()); // null
    }
}