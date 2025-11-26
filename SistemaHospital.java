import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SistemaHospital {
    private Map<String, PriorityQueue<Paciente>> colasPorEspecialidad = new HashMap<>();
    private Map<Integer, Paciente> registroPacientes = new HashMap<>();

    private static final String[] ESPECIALIDADES = {"Cardiología", "Neurología", "Dermatología", "Ginecología"};
    private static final String[] NOMBRES_DOCTORES = {"Ovando", "Santander", "Alfonsi", "Rodriguez"};

    ArbolBinario arbolBinario = new ArbolBinario();

    public void inicializarDoctores() {
        for (int i = 0; i < ESPECIALIDADES.length; i++) {
            arbolBinario.insertar(i + 1, NOMBRES_DOCTORES[i], ESPECIALIDADES[i]);
            colasPorEspecialidad.put(ESPECIALIDADES[i], new PriorityQueue<>());
        }
    }

    // Registrar sólo el perfil del paciente (no lo añade automáticamente a la cola)
    public void registrarPaciente(Paciente p) {
        if (registroPacientes.containsKey(p.getId())) {
            System.out.println("ID de paciente ya registrado. Use solicitarCita para agendar.");
            return;
        }
        registroPacientes.put(p.getId(), p);
        System.out.println("Paciente registrado: " + p.getNombre());
    }

    // Solicitar cita: añade un paciente existente a la cola de la especialidad
    public void solicitarCita(int idPaciente, String especialidad) {
        Paciente p = registroPacientes.get(idPaciente);
        if (p == null) {
            System.out.println("Paciente con ID " + idPaciente + " no encontrado. Regístrelo primero.");
            return;
        }
        p.agregarHistorial("Solicita atención en " + especialidad);
        p.setEspecialidadSolicitada(especialidad);
        PriorityQueue<Paciente> cola = colasPorEspecialidad.get(especialidad);
        if (cola == null) {
            cola = new PriorityQueue<>();
            colasPorEspecialidad.put(especialidad, cola);
        }
        cola.add(p);
        System.out.println("Cita solicitada: " + p.getNombre() + " en " + especialidad);
    }

    public void atenderPaciente(String especialidad) {
        PriorityQueue<Paciente> cola = colasPorEspecialidad.get(especialidad);
        if (cola == null || cola.isEmpty()) {
            System.out.println("No hay pacientes en espera para " + especialidad + ".");
            return;
        }
        Paciente p = cola.poll();
        Doctor doctor = arbolBinario.buscarPorEspecialidad(especialidad);
        if (doctor == null) {
            System.out.println("No hay doctor disponible para " + especialidad + ".");
            return;
        }
        System.out.println("Atendiendo a: " + p.getNombre() + " (Edad: " + p.getEdad() + ", Prioridad: " + p.getPrioridad() + ") con el Dr. " + doctor.nombre + " (" + doctor.especialidad + ")");
        p.agregarHistorial("Asignado al Dr. " + doctor.nombre + " (" + doctor.especialidad + ")");
        p.agregarHistorial("Atendido por Dr. " + doctor.nombre + " (" + doctor.especialidad + ")");
    }

    public void mostrarColas() {
        for (String esp : ESPECIALIDADES) {
            PriorityQueue<Paciente> cola = colasPorEspecialidad.get(esp);
            System.out.println("Cola - " + esp + ":");
            if (cola == null || cola.isEmpty()) {
                System.out.println("  (vacía)");
                continue;
            }
            List<Paciente> lista = new ArrayList<>(cola);
            Collections.sort(lista); // usa compareTo (prioridad)
            for (Paciente p : lista) {
                System.out.println("  - " + p.getNombre() + " (Edad: " + p.getEdad() + ", Prioridad: " + p.getPrioridad() + ")");
            }
        }
    }

    public void mostrarHistorialPaciente(int id) {
        Paciente p = registroPacientes.get(id);
        if (p == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }
        System.out.println("Historial médico de " + p.getNombre() + ":");
        p.mostrarHistorial();
    }

    public String[] getEspecialidades() {
        return ESPECIALIDADES;
    }
}
