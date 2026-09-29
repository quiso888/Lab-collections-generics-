// Esta clase junta dos restricciones a la vez: "T extends Number & Comparable<T>".
// Eso me permite tanto hacer operaciones matemáticas (sumar, restar) como comparar
// (máximo, mínimo) sobre cualquier tipo numérico, sin escribir una calculadora
// distinta para Integer, Double, etc.
package com.tuempresa.labs.generics.Avanzado;

public class CalculadoraAvanzada<T extends Number & Comparable<T>> {

    public double sumar(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public double restar(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public T maximo(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public T minimo(T a, T b) {
        return a.compareTo(b) <= 0 ? a : b;
    }

    public static void main(String[] args) {
        CalculadoraAvanzada<Integer> calc = new CalculadoraAvanzada<>();
        System.out.println("Suma: " + calc.sumar(10, 20));
        System.out.println("Resta: " + calc.restar(20, 10));
        System.out.println("Máximo: " + calc.maximo(10, 20));
        System.out.println("Mínimo: " + calc.minimo(10, 20));
    }
}
