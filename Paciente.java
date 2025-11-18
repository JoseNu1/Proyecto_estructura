import java.util.LinkedList;

public class Paciente implements Comparable<Paciente> {
    private int id;
    private String nombre;
    private int edad;
    private int prioridad;

    private LinkedList<String> historial;

    public Paciente(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.historial = new LinkedList<>();
        // Prioridad por edad
        if (edad >= 65) {
            this.prioridad = 3; // Alta
        } else if (edad <= 12) {
            this.prioridad = 2; // Media
        } else {
            this.prioridad = 1; // Baja
        }
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public int getPrioridad() { return prioridad; }

    public void agregarHistorial(String registro) {
        historial.add(registro);
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
        // Prioridad mayor = más urgente
        return Integer.compare(otro.prioridad, this.prioridad);
    }
}
