import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Paciente implements Comparable<Paciente> {
    private int id;
    private String nombre;
    private int edad;
    private int prioridad;

    private LinkedList<String> historial;
    private String especialidadSolicitada;

    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Paciente(int id, String nombre, int edad, String especialidadSolicitada) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.historial = new LinkedList<>();
        this.especialidadSolicitada = especialidadSolicitada;
        if (edad >= 65) {
            this.prioridad = 3;
        } else if (edad <= 12) {
            this.prioridad = 2;
        } else {
            this.prioridad = 1;
        }
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public int getPrioridad() { return prioridad; }
    public String getEspecialidadSolicitada() { return especialidadSolicitada; }

    public void setEspecialidadSolicitada(String especialidad) { this.especialidadSolicitada = especialidad; }

    public void agregarHistorial(String registro) {
        String ts = LocalDateTime.now().format(TS);
        historial.add("[" + ts + "] " + registro);
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        for (String registro : historial) {
            System.out.println("- " + registro);
        }
    }

    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(otro.prioridad, this.prioridad);
    }
}
