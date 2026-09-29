// Esta clase es parecida a Caja<T>, pero aquí restrinjo el tipo con "extends Number"
// para asegurarme de que solo reciba números (Integer, Double, etc.) y así poder
// usar doubleValue() para calcular el doble del valor guardado sin problemas.
package com.tuempresa.labs.generics.medio;

public class CajaNumerica<T extends Number> {

    private T numero;

    public CajaNumerica(T numero) {
        this.numero = numero;
    }

    public double doble() {
        return numero.doubleValue() * 2;
    }

    public static void main(String[] args) {
        CajaNumerica<Integer> cajaEntera = new CajaNumerica<>(10);
        System.out.println("Doble: " + cajaEntera.doble());

        CajaNumerica<Double> cajaDecimal = new CajaNumerica<>(3.5);
        System.out.println("Doble: " + cajaDecimal.doble());
    }
}
