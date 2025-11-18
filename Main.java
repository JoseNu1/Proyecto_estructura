import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaHospital sistema = new SistemaHospital();
        sistema.inicializarDoctores();

        int opcion;

        do {
            System.out.println("\n=== SISTEMA HOSPITALARIO ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Mostrar pacientes en cola");
            System.out.println("3. Atender paciente");
            System.out.println("4. Mostrar doctores");
            System.out.println("5. Mostrar historial médico de paciente");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del paciente: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    // Selección de especialidad
                    System.out.println("Seleccione el tipo de trato/especialidad:");
                    System.out.println("1. Cardiología (Ovando)");
                    System.out.println("2. Neurología (Santander)");
                    System.out.println("3. Dermatología (Alfonsi)");
                    System.out.println("4. Ginecología (Rodriguez)");
                    System.out.print("Opción: ");
                    int opcionEspecialidad = sc.nextInt();
                    sc.nextLine();
                    String especialidad = "";
                    switch (opcionEspecialidad) {
                        case 1: especialidad = "Cardiología"; break;
                        case 2: especialidad = "Neurología"; break;
                        case 3: especialidad = "Dermatología"; break;
                        case 4: especialidad = "Ginecología"; break;
                        default: especialidad = "Cardiología"; break;
                    }

                    Paciente paciente = new Paciente(id, nombre, edad);
                    paciente.agregarHistorial("Solicita atención en " + especialidad);
                    paciente.agregarHistorial("Doctor asignado: " + sistema.arbolBinario.buscarPorEspecialidad(especialidad).nombre);
                    sistema.registrarPaciente(paciente);
                    break;

                case 2:
                    sistema.mostrarCola();
                    break;

                case 3:
                    sistema.atenderPaciente();
                    break;

                case 4:
                    System.out.println("Doctores disponibles:");
                    sistema.arbolBinario.mostrarInOrden();
                    break;

                case 5:
                    System.out.print("Ingrese el ID del paciente: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;
                    for (Paciente p : sistema.colaPacientes) {
                        if (p.getId() == idBuscar) {
                            System.out.println("Historial médico de " + p.getNombre() + ":");
                            p.mostrarHistorial();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Paciente no encontrado en la cola.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 6);
        sc.close();
    }
}

