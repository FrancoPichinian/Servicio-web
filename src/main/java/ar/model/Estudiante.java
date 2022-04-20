package ar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Estudiante {
    private String nombre;
    private String apellido;
    private List<Curso> cursos;

    public Estudiante(String nombre, String apellido) {
        this.nombre = new NotNullNotEmpty(nombre).value();;
        this.apellido = new NotNullNotEmpty(apellido).value();
        this.cursos = new ArrayList<>();
    }

    public void addCurso(String curso) {
        this.cursos.add(new Curso (new NotNullNotEmpty(curso).value));
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + "]";
    }

    public boolean containsApellido(String apellido) {
        return this.apellido.contains(apellido);
    }

    public Map<String, Object> toMap() {
        var map = new HashMap<String, Object>(
                Map.of("nombre", nombre, "apellido", apellido));

        if (this.cursos != null && this.cursos.size() > 0) {
            map.put("cursos", cursos.stream().map((e) -> e.toMap())
                    .collect(Collectors.toList()));
        }
        return map;
    }
}
