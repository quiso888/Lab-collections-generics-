package Ejercicio10;

public class Main {
        // 10. En un edificio con control de acceso, los empleados deben identificarse mediante un código
    // único para poder ingresar. Para gestionar estos accesos sin permitir duplicados, se utilizará un
    // HashSet, donde cada ID de empleado será almacenado y verificado antes de permitir la entrada.
    static void main() {
        ControlAcceso control = new ControlAcceso();

        // 1. Se registran los códigos de los empleados
        control.registrarEmpleado("E001");
        control.registrarEmpleado("E002");
        control.registrarEmpleado("E003");
        IO.println(control);         // [E001, E002, E003] (el HashSet no garantiza orden)

        // 2. No se permiten duplicados: registrar el mismo código devuelve false
        IO.println("¿Se registró E002 otra vez? " + control.registrarEmpleado("E002")); // false
        IO.println("Cantidad de empleados: " + control.cantidadEmpleados());             // 3

        // 3. Se verifica el código antes de permitir la entrada
        IO.println("¿Puede entrar E001? " + control.permitirEntrada("E001")); // true
        IO.println("¿Puede entrar E999? " + control.permitirEntrada("E999")); // false

        // 4. Si se elimina un empleado, ya no puede entrar
        control.eliminarEmpleado("E003");
        IO.println("¿Puede entrar E003? " + control.permitirEntrada("E003")); // false
        IO.println(control);         // [E001, E002]

        // 5. Validación: no se aceptan códigos vacíos
        IO.println("¿Se registró un código vacío? " + control.registrarEmpleado("  ")); // false
    }
}
