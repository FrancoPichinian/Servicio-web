package ar.servicios;

import java.util.List;
import ar.model.Estudiante;

public interface Estudiantes {

    void crearEstudiante(String nombre, String apellido, String curso);

    List<Estudiante> estudiantes(String apellido);

}
