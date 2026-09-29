package com.tuempresa.labs.collections.Ejercicio8;

public class Main {
    // 8. Un editor de texto debe permitir deshacer los cambios realizados. Para lograrlo, se
    // empleará un Vector (String) que guarda el historial de cambios, donde el último cambio
    // realizado es el primero en deshacerse, y que es seguro al usarse desde varios hilos.
    static void main() {
        EditorTexto editor = new EditorTexto();

        // 1. El usuario escribe -> cada cambio se guarda al final del historial
        editor.escribir("Hola");
        editor.escribir(" mundo");
        editor.escribir("!");
        IO.println(editor);                                  // [Hola,  mundo, !] -> "Hola mundo!"

        // 2. Se deshace el último cambio (LIFO)
        IO.println("Deshaciendo: " + editor.deshacer());     // !
        IO.println(editor);                                  // [Hola,  mundo] -> "Hola mundo"

        // 3. Se consulta el último cambio sin quitarlo
        IO.println("Último cambio: " + editor.verUltimoCambio()); // " mundo"
        IO.println("Cambios en el historial: " + editor.cantidadCambios()); // 2

        // 4. Validación: no se aceptan textos vacíos ni nulos
        IO.println("¿Se guardó un texto vacío? " + editor.escribir(""));   // false
        IO.println("¿Se guardó un texto nulo? " + editor.escribir(null));  // false

        // 5. Se deshacen todos los cambios hasta vaciar el historial
        while (editor.puedeDeshacer()) {
            IO.println("Deshaciendo: " + editor.deshacer());
        }

        // 6. Sin cambios, deshacer devuelve null en vez de lanzar una excepción
        IO.println("Deshacer sin cambios: " + editor.deshacer()); // null
    }
}
