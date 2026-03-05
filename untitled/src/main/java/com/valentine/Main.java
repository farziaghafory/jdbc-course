package com.valentine;

import com.valentine.model.curso;
import com.valentine.repository.CursoRepositorInMemory;
import com.valentine.repository.cursoRepository;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        cursoRepository repo = new CursoRepositorInMemory();
        curso c1 = repo.crearCurso(new curso(null, null, "Mattematics"));
        curso c2 = repo.crearCurso(new curso(null, false, "History"));
        curso c3 = repo.crearCurso(new curso(null, true, "Programming"));
        repo.activar(c2.getId());
        System.out.println(" ACTIVES");
        List<curso> activos = repo.listarPorEstado(true);
        activos.forEach(c -> System.out.println(c.getId() + c.getNombre() + c.getActivo())
        );
        System.out.println(" Ordened por name of the DESC");
        repo.listarOrdenadoPor("nombre", "DESC").forEach(c -> System.out.println(c.getId()+ c.getNombre()));
    }
}