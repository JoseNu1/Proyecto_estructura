import java.util.LinkedList;
import java.util.Queue;

public class SistemaHospital {

    Queue<Paciente> colaPacientes = new LinkedList<>();
    ArbolBinario arbolBinario = new ArbolBinario();

    // Registrar paciente en la cola
    public void registrarPaciente(Paciente p) {
        colaPacientes.add(p);
        System.out.println("Paciente agregado a la cola.");
    }

    // Atender paciente
    public void atenderPaciente(int idDoctor) {
        if (colaPacientes.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }

        Doctor doctor = arbolBinario.buscar(idDoctor);

        if (doctor == null) {
            System.out.println("El doctor no existe.");
            return;
        }

        Paciente p = colaPacientes.poll();
        System.out.println("Atendiendo a: " + p.getNombre() + " con el Dr. " + doctor.nombre);
        p.agregarHistorial("Atendido por " + doctor.nombre + " (" + doctor.especialidad + ")");
    }

    // Mostrar pacientes en espera
    public void mostrarCola() {
        if (colaPacientes.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.println("Pacientes en espera:");
        for (Paciente p : colaPacientes) {
            System.out.println("- " + p.getNombre());
        }
    }
}
