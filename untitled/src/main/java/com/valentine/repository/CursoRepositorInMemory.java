package com.valentine.repository;

import com.valentine.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositorInMemory implements CursoRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3309/practice",
                "dam1",
                "dam1"
        ); // never put password in main
    }

    @Override
    public Curso crearCurso(Curso curso) throws SQLException {
        if (curso.getActivo() == null) {
            curso.setActivo(true);
        }
        String sql = "INSERT INTO curso (activo, nombre) VALUES (?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setBoolean(1, curso.getActivo());
            ps.setString(2, curso.getNombre());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {curso.setId(rs.getInt(1));
            } return curso;
        }
    }
    public void activar(Integer id) throws SQLException {
        String sql = "UPDATE curso SET activo = true WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    @Override
    public void eliminarSiNombreContiene(String texto) throws SQLException {
        String sql = "DELETE FROM curso WHERE nombre LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + texto + "%");
            ps.executeUpdate();
        }}

    @Override
    public List<Curso> listarPorEstado(boolean estado) throws SQLException {
        String sql = "SELECT * FROM curso WHERE activo = ?";
        List<Curso> lista = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Curso c = new Curso(rs.getInt("id"),
                        rs.getBoolean("active"),
                        rs.getString("name")
                );
                lista.add(c);
            }}
        return lista;
    }
    @Override
    public List<Curso> listarOrdenadoPor(String campo, String tipo) throws SQLException {
        if (!campo.equals("id") && !campo.equals("boolean") && !campo.equals("name")) ;
        if (!tipo.equalsIgnoreCase("ASC") &&
                !tipo.equalsIgnoreCase("DESC")) {
            throw new IllegalArgumentException("invalid type");
        }
        String sql = "SELECT * FROM curso ORDER BY " + campo + tipo;
        List<Curso> lista = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // id, active, name
                lista.add(new Curso(rs.getInt("id"), rs.getBoolean("active"), rs.getString("name")));
            }
        }
        return lista;
    }
}
