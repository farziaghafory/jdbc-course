package com.valentine.repository;

import com.valentine.model.Curso;

import java.sql.SQLException;
import java.util.List;

public interface CursoRepository {

        Curso crearCurso(Curso curso) throws SQLException;

        void activar(Integer id) throws SQLException;

        void eliminarSiNombreContiene(String texto) throws SQLException;

        List<Curso> listarPorEstado(boolean estado) throws SQLException;

        List<Curso> listarOrdenadoPor(String campo, String tipo) throws SQLException;
    }

