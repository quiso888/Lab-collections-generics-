package Ejercicio12;

public class Main {
    // 12. En una universidad, los nombres de los estudiantes deben mantenerse ordenados
    // alfabéticamente para facilitar su búsqueda. Para ello, se utilizará un TreeSet, que
    // automáticamente organizará los nombres de los estudiantes a medida que se agregan y permitirá
    // obtener fácilmente el primer y el último nombre de la lista.
    static void main() {
        Universidad universidad = new Universidad();

        // 1. Se agregan estudiantes en desorden -> el TreeSet los ordena solo
        universidad.agregarEstudiante("Mateo");
        universidad.agregarEstudiante("Carlos");
        universidad.agregarEstudiante("Valentina");
        universidad.agregarEstudiante("Andrea");
        IO.println(universidad);     // [Andrea, Carlos, Mateo, Valentina]

        // 2. Un nuevo estudiante queda en su lugar alfabético
        universidad.agregarEstudiante("Laura");
        IO.println(universidad);     // [Andrea, Carlos, Laura, Mateo, Valentina]

        // 3. Primer y último nombre de la lista
        IO.println("Primer estudiante: " + universidad.primerEstudiante()); // Andrea
        IO.println("Último estudiante: " + universidad.ultimoEstudiante()); // Valentina

        // 4. No se permiten duplicados (sin importar mayúsculas)
        IO.println("¿Se agregó carlos otra vez? " + universidad.agregarEstudiante("carlos")); // false
        IO.println("Cantidad de estudiantes: " + universidad.cantidadEstudiantes());          // 5

        // 5. Búsqueda de un estudiante
        IO.println("¿Está Laura? " + universidad.buscarEstudiante("Laura")); // true
        IO.println("¿Está Pedro? " + universidad.buscarEstudiante("Pedro")); // false

        // 6. Sin estudiantes, primero y último devuelven null en vez de lanzar una excepción
        Universidad vacia = new Universidad();
        IO.println("Primer estudiante (vacía): " + vacia.primerEstudiante()); // null
    }
}