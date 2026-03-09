package com.valentine.service;

import com.valentine.model.Curso;

import java.util.List;

public interface CursoService {


        Curso getId(Integer id);

        List<Curso> getAlumnos();

        Curso crearCursos(Curso cursos);

        Curso modificarCursos(Curso cursos);

}
