import java.util.Scanner;
import java.util.Calendar;

public class Parqueadero {
    int MAX_PUESTOS = 20; // Máximo número de puestos
    boolean[] puestosMotos = new boolean[MAX_PUESTOS]; // Arreglo para chequear si los puestos están ocupados
     Scanner scanner = new Scanner(System.in); // Scanner para leer entrada del usuario

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero(); // Crear instancia de Parqueadero
        parqueadero.menuPrincipal(); // Llamar al método del menú principal
    }

    private void menuPrincipal() {
        int opcion; // Variable para almacenar la opción seleccionada

        do {
            // Mostrar menú principal
            System.out.println("==== Menú Principal ====");
            System.out.println("1. Registro de Motos");
            System.out.println("2. Cobros de Parqueadero");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Manejar entrada de opción
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next(); // Limpiar entrada incorrecta
            }
            opcion = scanner.nextInt();

            if (isHorarioValido()) { // Verificar si el horario es válido
                // Ejecutar opción seleccionada
                if (opcion == 1) {
                    registrarMoto(); // Registrar moto en el parqueadero
                } else if (opcion == 2) {
                    cobrar(); // Calcular cobro para la moto
                } else if (opcion == 3) {
                    System.out.println("Saliendo de la aplicación..."); // Mensaje de salida
                } else {
                    System.out.println("Opción inválida. Intente de nuevo."); // Opción no válida
                }
            } else {
                System.out.println("El parqueadero está cerrado. Horario de funcionamiento: 07:00 a 22:00."); // Mensaje de parqueadero cerrado
            }
        } while (opcion != 3); // Continuar hasta que el usuario elija salir
    }

    private void registrarMoto() {
        mostrarEstadoPuestos(); // Mostrar el estado actual de los puestos
        System.out.print("Seleccione el puesto (0-19) para registrar la moto: ");
        
        int puesto;
        // Manejar entrada de puesto
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next(); // Limpiar entrada incorrecta
            }
            puesto = scanner.nextInt();
            if (puesto >= 0 && puesto < MAX_PUESTOS) {
                break; // Salir del ciclo si el puesto es válido
            } else {
                System.out.println("Puesto inválido. Debe estar entre 0 y 19."); // Mensaje de puesto inválido
            }
        }

        // Verificar si el puesto está ocupado
        if (!puestosMotos[puesto]) {
            puestosMotos[puesto] = true; // Marcar el puesto como ocupado
            System.out.println("Moto registrada en el puesto " + puesto + ".");
        } else {
            System.out.println("El puesto " + puesto + " ya está ocupado."); // Mensaje de ocupación
        }
    }

    private void cobrar() {
        System.out.print("Ingrese el puesto de la moto para cobrar: ");
        
        int puesto;
        // Manejar entrada de puesto
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next(); // Limpiar entrada incorrecta
            }
            puesto = scanner.nextInt();
            if (puesto >= 0 && puesto < MAX_PUESTOS) {
                break; // Salir del ciclo si el puesto es válido
            } else {
                System.out.println("Puesto inválido. Debe estar entre 0 y 19."); // Mensaje de puesto inválido
            }
        }

        // Verificar si el puesto tiene una moto registrada
        if (puestosMotos[puesto]) {
            System.out.print("Ingrese la cantidad de minutos que estuvo la moto estacionada: ");
            int minutosEstacionados;
            // Manejar entrada de minutos
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Debe ingresar un número.");
                    scanner.next(); // Limpiar entrada incorrecta
                }
                minutosEstacionados = scanner.nextInt();
                if (minutosEstacionados >= 0) {
                    break; // Salir del ciclo si los minutos son válidos
                } else {
                    System.out.println("Los minutos deben ser un número positivo."); // Mensaje de minutos inválidos
                }
            }

            double monto = calcularCobro(minutosEstacionados); // Calcular cobro basado en los minutos proporcionados
            System.out.println("Monto a pagar para el puesto " + puesto + ": $" + monto);
            puestosMotos[puesto] = false; // Liberar el puesto
            System.out.println("Puesto " + puesto + " liberado."); // Mensaje de liberación
        } else {
            System.out.println("El puesto " + puesto + " no tiene una moto registrada."); // Mensaje si no hay moto
        }
    }

    private double calcularCobro(int minutosEstacionados) {
        // Calcular el costo basado en los minutos
        if (minutosEstacionados <= 30) {
            return 0; // Sin costo por los primeros 30 minutos
        } else if (minutosEstacionados <= 60) {
            return 800; // Costo de $800 de 31 a 60 minutos
        } else {
            return 2000; // Costo de $2000 después de los 60 minutos
        }
    }

    private void mostrarEstadoPuestos() {
        // Mostrar el estado de los puestos
        System.out.println("Estado de puestos:");
        for (int i = 0; i < MAX_PUESTOS; i++) {
            System.out.print((puestosMotos[i] ? "[X]" : "[ ]") + " "); // Mostrar ocupación
        }
        System.out.println();
    }

    private boolean isHorarioValido() {
        Calendar calendario = Calendar.getInstance(); // Obtener la hora actual
        int hora = calendario.get(Calendar.HOUR_OF_DAY); // Obtener la hora (0-23)
        return hora >= 7 && hora < 22; // Horario válido entre 07:00 y 21:59
    }
}