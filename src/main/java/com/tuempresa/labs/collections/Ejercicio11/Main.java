package com.tuempresa.labs.collections.Ejercicio11;

public class Main {
    // 11. En una aplicación de música, los usuarios pueden marcar canciones como favoritas. Para
    // garantizar que las canciones favoritas se mantengan en el orden en que fueron añadidas sin
    // permitir duplicados, se empleará un LinkedHashSet, el cual conservará la secuencia de inserción
    // y asegurará que no haya repeticiones.
    static void main() {
        ListaFavoritos favoritos = new ListaFavoritos();

        // 1. El usuario marca canciones como favoritas -> se guardan en ese orden
        favoritos.agregarFavorita("Bohemian Rhapsody");
        favoritos.agregarFavorita("Mi Primera Cana");
        favoritos.agregarFavorita("Hotel California");
        IO.println(favoritos);       // [Bohemian Rhapsody, Mi Primera Cana, Hotel California]

        // 2. No se permiten repetidas: agregar la misma canción devuelve false
        IO.println("¿Se agregó Mi Primera Cana otra vez? " + favoritos.agregarFavorita("Mi Primera Cana")); // false
        IO.println(favoritos);       // el orden no cambia

        // 3. Al quitar una canción, las demás mantienen su orden
        favoritos.quitarFavorita("Mi Primera Cana");
        IO.println(favoritos);       // [Bohemian Rhapsody, Hotel California]

        // 4. Si se vuelve a agregar, queda al final
        favoritos.agregarFavorita("Mi Primera Cana");
        IO.println(favoritos);       // [Bohemian Rhapsody, Hotel California, Mi Primera Cana]

        IO.println("¿Hotel California es favorita? " + favoritos.esFavorita("Hotel California")); // true
        IO.println("Cantidad de favoritas: " + favoritos.cantidadFavoritas());                    // 3

        // 5. Validación: no se aceptan nombres vacíos
        IO.println("¿Se agregó un nombre vacío? " + favoritos.agregarFavorita("  ")); // false
    }
}