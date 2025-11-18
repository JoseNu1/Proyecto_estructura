import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaHospital sistema = new SistemaHospital();

        // Doctores de ejemplo
        sistema.arbolBinario.insertar(10, "Dr. Pérez", "Cardiología");
        sistema.arbolBinario.insertar(5, "Dr. López", "Pediatría");
        sistema.arbolBinario.insertar(15, "Dr. Núñez", "Neurología");

        int opcion;

        do {
            System.out.println("\n=== SISTEMA HOSPITALARIO ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Mostrar pacientes en cola");
            System.out.println("3. Atender paciente");
            System.out.println("4. Buscar doctor");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID del paciente: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    sistema.registrarPaciente(new Paciente(id, nombre));
                    break;

                case 2:
                    sistema.mostrarCola();
                    break;

                case 3:
                    System.out.print("ID del doctor que atenderá: ");
                    int doc = sc.nextInt();
                    sistema.atenderPaciente(doc);
                    break;

                case 4:
                    System.out.print("ID del doctor: ");
                    int idDoc = sc.nextInt();
                    Doctor d = sistema.arbolBinario.buscar(idDoc);
                    if (d != null) {
                        System.out.println("Doctor encontrado: " + d.nombre + " (" + d.especialidad + ")");
                    } else {
                        System.out.println("No existe ese doctor.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 5);

        sc.close();
    }
}
