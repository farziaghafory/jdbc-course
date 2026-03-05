package com.valentine.repository;

import com.valentine.model.curso;

import java.sql.SQLException;
import java.util.List;

public interface cursoRepository {

        curso crearCurso(curso curso) throws SQLException;

        void activar(Integer id) throws SQLException;

        void eliminarSiNombreContiene(String texto) throws SQLException;

        List<curso> listarPorEstado(boolean estado) throws SQLException;

        List<curso> listarOrdenadoPor(String campo, String tipo) throws SQLException;
    }

