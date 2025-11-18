public class ArbolBinario {

    public Doctor raiz;

    public void insertar(int id, String nombre, String especialidad) {
        raiz = insertarRec(raiz, id, nombre, especialidad);
    }

    private Doctor insertarRec(Doctor actual, int id, String nombre, String especialidad) {
        if (actual == null) {
            return new Doctor(id, nombre, especialidad);
        }

        if (id < actual.id) {
            actual.izquierda = insertarRec(actual.izquierda, id, nombre, especialidad);
        } else {
            actual.derecha = insertarRec(actual.derecha, id, nombre, especialidad);
        }

        return actual;
    }

    public Doctor buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Doctor buscarRec(Doctor actual, int id) {
        if (actual == null || actual.id == id)
            return actual;

        if (id < actual.id)
            return buscarRec(actual.izquierda, id);
        else
            return buscarRec(actual.derecha, id);
    }

    public void mostrarInOrden() {
        inOrden(raiz);
    }

    private void inOrden(Doctor d) {
        if (d != null) {
            inOrden(d.izquierda);
            System.out.println(d.id + " - " + d.nombre + " (" + d.especialidad + ")");
            inOrden(d.derecha);
        }
    }

        // Buscar doctor por especialidad (devuelve el primero que encuentra)
        public Doctor buscarPorEspecialidad(String especialidad) {
            return buscarPorEspecialidadRec(raiz, especialidad);
        }

        private Doctor buscarPorEspecialidadRec(Doctor actual, String especialidad) {
            if (actual == null) return null;
            if (actual.especialidad.equalsIgnoreCase(especialidad)) return actual;
            Doctor izq = buscarPorEspecialidadRec(actual.izquierda, especialidad);
            if (izq != null) return izq;
            return buscarPorEspecialidadRec(actual.derecha, especialidad);
        }
}
