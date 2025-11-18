import java.util.LinkedList;

public class Paciente {
    private int id;
    private String nombre;

    // Historial clínico -> LISTA ENLAZADA
    private LinkedList<String> historial;

    public Paciente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.historial = new LinkedList<>();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

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
}
