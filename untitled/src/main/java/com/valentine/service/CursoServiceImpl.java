package com.valentine.service;

import com.valentine.model.Curso;
import com.valentine.repository.CursoRepository;

import java.sql.SQLException;
import java.util.List;

public class CursoServiceImpl implements CursoRepository{
    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    @Override
    public Curso crearCurso(Curso curso) throws SQLException {
        return null;
    }

    @Override
    public void activar(Integer id) throws SQLException {

    }

    @Override
    public void eliminarSiNombreContiene(String texto) throws SQLException {

    }

    @Override
    public List<Curso> listarPorEstado(boolean estado) throws SQLException {
        return List.of();
    }

    @Override
    public List<Curso> listarOrdenadoPor(String campo, String tipo) throws SQLException {
        return List.of();
    }
}
