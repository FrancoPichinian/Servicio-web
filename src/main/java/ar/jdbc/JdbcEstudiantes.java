package ar.jdbc;

import java.util.List;
import java.util.stream.Collectors;

import ar.model.Estudiante;
import ar.servicios.Estudiantes;

public class JdbcEstudiantes implements Estudiantes {

    @Override
    public void crearEstudiante(String nombre, String apellido, String curso) {
        Estudiante e = new Estudiante(nombre, apellido);
        e.addCurso(curso);
        System.out.println(e.toString());
    }

    @Override
    public List<Estudiante> estudiantes(String apellido) {
        Estudiante e1 = new Estudiante("Agustin", "Martinez");
        Estudiante e2 = new Estudiante("Francisco", "Garcia");
        Estudiante e3 = new Estudiante("Juan", "Perez");

        e1.addCurso("Angular");
        e1.addCurso("Python");
        e2.addCurso("Java");
        e3.addCurso("Docker");

        var estudiantes = List.of(e1, e2, e3);

        if (apellido == null || apellido.isEmpty())
            return estudiantes;

        return estudiantes.stream().filter((e) -> {
            return e.containsApellido(apellido);
        }).collect(Collectors.toList());
    }
}
