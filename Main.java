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
            System.out.println("6. Solicitar cita para paciente registrado");
            System.out.println("7. Salir");
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

                    Paciente paciente = new Paciente(id, nombre, edad, "");
                    sistema.registrarPaciente(paciente);
                    break;

                case 2:
                    sistema.mostrarColas();
                    break;

                case 3:
                    System.out.println("Seleccione la especialidad a atender:");
                    System.out.println("1. Cardiología");
                    System.out.println("2. Neurología");
                    System.out.println("3. Dermatología");
                    System.out.println("4. Ginecología");
                    System.out.print("Opción: ");
                    int opAtender = sc.nextInt();
                    sc.nextLine();
                    String espAtender = "Cardiología";
                    switch (opAtender) {
                        case 1: espAtender = "Cardiología"; break;
                        case 2: espAtender = "Neurología"; break;
                        case 3: espAtender = "Dermatología"; break;
                        case 4: espAtender = "Ginecología"; break;
                    }
                    sistema.atenderPaciente(espAtender);
                    break;

                case 4:
                    System.out.println("Doctores disponibles:");
                    sistema.arbolBinario.mostrarInOrden();
                    break;

                case 5:
                    System.out.print("Ingrese el ID del paciente: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();
                    sistema.mostrarHistorialPaciente(idBuscar);
                    break;
                case 6:
                    System.out.print("Ingrese el ID del paciente para solicitar cita: ");
                    int idCita = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Seleccione la especialidad para la cita:");
                    System.out.println("1. Cardiología");
                    System.out.println("2. Neurología");
                    System.out.println("3. Dermatología");
                    System.out.println("4. Ginecología");
                    System.out.print("Opción: ");
                    int opEsp = sc.nextInt();
                    sc.nextLine();
                    String esp = "Cardiología";
                    switch (opEsp) {
                        case 1: esp = "Cardiología"; break;
                        case 2: esp = "Neurología"; break;
                        case 3: esp = "Dermatología"; break;
                        case 4: esp = "Ginecología"; break;
                    }
                    sistema.solicitarCita(idCita, esp);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 7);
        sc.close();
    }
}

