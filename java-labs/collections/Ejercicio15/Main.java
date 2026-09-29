package Ejercicio15;

public class Main {
    // 15. Un directorio telefónico necesita almacenar nombres junto con sus respectivos números de
    // teléfono y permitir búsquedas eficientes. Para este caso, se usará un HashMap, el cual asociará
    // cada nombre con su número telefónico, posibilitando consultas rápidas y evitando duplicados.
    static void main() {
        DirectorioTelefonico directorio = new DirectorioTelefonico();

        // 1. Se agregan contactos (nombre -> número)
        directorio.agregarContacto("Ana", "3001234567");
        directorio.agregarContacto("Luis", "3109876543");
        directorio.agregarContacto("Marta", "3205551234");
        IO.println(directorio);      // {Ana=3001234567, Luis=3109876543, Marta=3205551234} (sin orden fijo)

        // 2. Búsqueda rápida por nombre
        IO.println("Número de Luis: " + directorio.buscarNumero("Luis"));   // 3109876543
        IO.println("Número de Pedro: " + directorio.buscarNumero("Pedro")); // null

        // 3. No se permiten nombres duplicados
        IO.println("¿Se agregó Ana otra vez? " + directorio.agregarContacto("Ana", "3000000000")); // false
        IO.println("Número de Ana: " + directorio.buscarNumero("Ana"));     // 3001234567 (no cambió)

        // 4. Para cambiar un número se usa actualizar
        directorio.actualizarNumero("Ana", "3000000000");
        IO.println("Nuevo número de Ana: " + directorio.buscarNumero("Ana")); // 3000000000

        // 5. Eliminar un contacto
        directorio.eliminarContacto("Marta");
        IO.println("¿Existe Marta? " + directorio.existeContacto("Marta")); // false
        IO.println("Cantidad de contactos: " + directorio.cantidadContactos()); // 2

        // 6. Validación: no se aceptan datos vacíos
        IO.println("¿Se agregó un contacto sin número? " + directorio.agregarContacto("Sofía", " ")); // false
    }
}
