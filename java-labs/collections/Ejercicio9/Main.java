package Ejercicio9;

public class Main {
    // 9. En la navegación web, los usuarios necesitan poder retroceder a páginas anteriores. Para
    // este propósito, se usará un Stack, que funciona como una pila LIFO (Last In, First Out). Cada
    // vez que el usuario visite una nueva página, esta se añadirá a la pila, y cuando decida volver
    // atrás, se eliminará la última página visitada para regresar a la anterior.
    static void main() {
        Navegador navegador = new Navegador();

        // 1. El usuario visita páginas -> cada una se pone encima de la pila
        navegador.visitar("google.com");
        navegador.visitar("youtube.com");
        navegador.visitar("github.com");
        IO.println(navegador);       // [google.com, youtube.com, github.com] -> Actual: github.com

        // 2. Retroceder quita la última página y regresa a la anterior (LIFO)
        IO.println("Retrocediendo a: " + navegador.retroceder()); // youtube.com
        IO.println(navegador);       // [google.com, youtube.com] -> Actual: youtube.com

        // 3. Una nueva visita queda encima de la pila
        navegador.visitar("uniquindio.edu.co");
        IO.println(navegador);       // [google.com, youtube.com, uniquindio.edu.co] -> Actual: uniquindio.edu.co

        // 4. Validación: no se aceptan direcciones vacías
        IO.println("¿Se visitó una dirección vacía? " + navegador.visitar("  ")); // false

        // 5. Se retrocede hasta la primera página
        while (navegador.puedeRetroceder()) {
            IO.println("Retrocediendo a: " + navegador.retroceder());
        }
        IO.println(navegador);       // [google.com] -> Actual: google.com

        // 6. En la primera página no se puede retroceder más: devuelve null
        IO.println("Retroceder desde la primera página: " + navegador.retroceder()); // null
    }
}
