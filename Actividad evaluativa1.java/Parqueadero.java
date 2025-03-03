import java.time.LocalTime;
import java.util.Scanner;

public class Parqueadero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Definir el arreglo de 20 puestos, 0: libre, 1: ocupado
        int[] puestos = new int[20]; // 0: libre, 1: ocupado
        // Arreglo para las horas de entrada (usaremos LocalTime)
        LocalTime[] entradas = new LocalTime[20];
        
        // Definir el horario del parqueadero
        LocalTime horaApertura = LocalTime.of(7, 0);  // 7:00 AM
        LocalTime horaCierre = LocalTime.of(22, 0);   // 10:00 PM
        
        int opcion;
        boolean continuar = true;
        
        while (continuar) {
            // Menú principal
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar Moto");
            System.out.println("2. Cobrar Tarifa");
            System.out.println("3. Ver Estado de los Puestos");
            System.out.println("4. Cerrar Aplicación");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            
            if (opcion == 1) {
                // Registrar moto
                System.out.print("Ingrese el número de puesto (0-19): ");
                int puestoRegistro = scanner.nextInt();
                
                if (puestoRegistro >= 0 && puestoRegistro < 20) {
                    if (puestos[puestoRegistro] == 0) { // Verificar si el puesto está libre
                        // Verificar la hora de entrada
                        LocalTime horaEntrada = LocalTime.now();
                        if (horaEntrada.isBefore(horaApertura) || horaEntrada.isAfter(horaCierre)) {
                            System.out.println("El parqueadero solo está abierto entre las 7:00 AM y las 10:00 PM.");
                        } else {
                            // Registrar la moto en el puesto
                            puestos[puestoRegistro] = 1;  // El puesto ahora está ocupado
                            entradas[puestoRegistro] = horaEntrada; // Guardar la hora de entrada
                            System.out.println("Moto registrada en el puesto " + puestoRegistro + " a las " + horaEntrada);
                        }
                    } else {
                        System.out.println("El puesto " + puestoRegistro + " ya está ocupado.");
                    }
                } else {
                    System.out.println("Número de puesto inválido.");
                }
            } else if (opcion == 2) {
                // Cobrar tarifa
                System.out.print("Ingrese el número de puesto para calcular el cobro (0-19): ");
                int puestoCobro = scanner.nextInt();
                
                if (puestoCobro >= 0 && puestoCobro < 20) {
                    if (puestos[puestoCobro] == 1) { // Verificar si el puesto está ocupado
                        // Verificar la hora de salida
                        LocalTime horaSalida = LocalTime.now();
                        if (horaSalida.isBefore(horaApertura) || horaSalida.isAfter(horaCierre)) {
                            System.out.println("El parqueadero solo está abierto entre las 7:00 AM y las 10:00 PM.");
                        } else {
                            // Calcular el tiempo de estacionamiento
                            long minutosEstacionado = entradas[puestoCobro].until(horaSalida, java.time.temporal.ChronoUnit.MINUTES);
                            System.out.println("Tiempo de estacionamiento: " + minutosEstacionado + " minutos");
                            
                            // Calcular la tarifa
                            int tarifa = 0;
                            if (minutosEstacionado <= 30) {
                                tarifa = 0;
                            } else if (minutosEstacionado <= 60) {
                                tarifa = 800;
                            } else {
                                tarifa = 2000;
                            }
                            
                            System.out.println("El cobro para el puesto " + puestoCobro + " es: $" + tarifa);
                            // Liberar el puesto
                            puestos[puestoCobro] = 0;
                        }
                    } else {
                        System.out.println("El puesto " + puestoCobro + " está libre.");
                    }
                } else {
                    System.out.println("Número de puesto inválido.");
                }
            } else if (opcion == 3) {
                // Mostrar el estado de los puestos
                System.out.println("\n--- Estado de los Puestos ---");
                for (int i = 0; i < 20; i++) {
                    if (puestos[i] == 0) {
                        System.out.println("Puesto " + i + ": Libre");
                    } else {
                        System.out.println("Puesto " + i + ": Ocupado, Hora de entrada: " + entradas[i]);
                    }
                }
            } else if (opcion == 4) {
                // Cerrar la aplicación
                System.out.println("Cerrando la aplicación...");
                continuar = false;  // Salir del ciclo
            } else {
                System.out.println("Opción inválida.");
            }
        }
        
        scanner.close(); // Cerrar el scanner
    }

}