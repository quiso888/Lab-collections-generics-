// Esta clase es una "caja" genérica que puede guardar cualquier tipo de dato (String, Integer, etc.)
// sin tener que crear una clase distinta para cada tipo. Uso T como comodín del tipo.
// guardar() mete un valor adentro y obtener() lo devuelve.
package com.tuempresa.labs.generics.basico;

public class Caja<T> {

    private T contenido;

    public void guardar(T valor) {
        this.contenido = valor;
    }

    public T obtener() {
        return contenido;
    }

    public static void main(String[] args) {
        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.guardar("Hola Mundo");
        System.out.println("Contenido: " + cajaTexto.obtener());

        Caja<Integer> cajaNumero = new Caja<>();
        cajaNumero.guardar(42);
        System.out.println("Contenido: " + cajaNumero.obtener());
    }
}
