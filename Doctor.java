public class Doctor {
    int id;
    String nombre;
    String especialidad;

    Doctor izquierda;
    Doctor derecha;

    public Doctor(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
}
