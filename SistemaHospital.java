
public class SistemaHospital {
    java.util.PriorityQueue<Paciente> colaPacientes = new java.util.PriorityQueue<>();

    private static final String[] ESPECIALIDADES = {"Cardiología", "Neurología", "Dermatología", "Ginecología"};
    private static final String[] NOMBRES_DOCTORES = {"Ovando", "Santander", "Alfonsi", "Rodriguez"};

    public void inicializarDoctores() {
        for (int i = 0; i < ESPECIALIDADES.length; i++) {
            arbolBinario.insertar(i + 1, NOMBRES_DOCTORES[i], ESPECIALIDADES[i]);
        }
    }
    ArbolBinario arbolBinario = new ArbolBinario();

    public void registrarPaciente(Paciente p) {
        colaPacientes.add(p);
        System.out.println("Paciente agregado a la cola.");
    }

    private int turnoDoctor = 0;
    public void atenderPaciente() {
        if (colaPacientes.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }

        String especialidad = ESPECIALIDADES[turnoDoctor % ESPECIALIDADES.length];
        Doctor doctor = arbolBinario.buscarPorEspecialidad(especialidad);
        turnoDoctor++;
        if (doctor == null) {
            System.out.println("No hay doctor disponible para " + especialidad);
            return;
        }

        Paciente p = colaPacientes.poll();
        System.out.println("Atendiendo a: " + p.getNombre() + " (Edad: " + p.getEdad() + ", Prioridad: " + p.getPrioridad() + ") con el Dr. " + doctor.nombre + " (" + doctor.especialidad + ")");
        p.agregarHistorial("Atendido por " + doctor.nombre + " (" + doctor.especialidad + ")");
    }

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
