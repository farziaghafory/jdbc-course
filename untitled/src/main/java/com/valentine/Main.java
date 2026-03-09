package com.valentine;

import com.valentine.model.Curso;
import com.valentine.repository.CursoRepositorInMemory;
import com.valentine.repository.CursoRepository;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        CursoRepository repo = new CursoRepositorInMemory();
        Curso c1 = repo.crearCurso(new Curso(null, null, "Mattematics"));
        Curso c2 = repo.crearCurso(new Curso(null, false, "History"));
        Curso c3 = repo.crearCurso(new Curso(null, true, "Programming"));
        repo.activar(c2.getId());
        System.out.println(" ACTIVES");
        List<Curso> activos = repo.listarPorEstado(true);
        activos.forEach(c -> System.out.println(c.getId() + c.getNombre() + c.getActivo())
        );
        System.out.println(" Ordened por name of the DESC");
        repo.listarOrdenadoPor("nombre", "DESC").forEach(c -> System.out.println(c.getId()+ c.getNombre()));
    }
}