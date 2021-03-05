/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Dominio.Sedes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author OtakuGT
 */
public class SedesDAO {
    private static final String SQL_SELECT = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes";
    private static final String SQL_INSERT = "INSERT INTO sedes(codigo_sede, nombre_sede, estatus_sede) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE sedes SET codigo_sede=?, nombre_sede=?, estatus_sede=? WHERE codigo_sede = ?";
    private static final String SQL_DELETE = "DELETE FROM sedes WHERE codigo_sede=?";
    private static final String SQL_QUERY = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes WHERE codigo_sede = ?";
    
    public List<Sedes> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sedes sede = null;
        List<Sedes> sedes = new ArrayList<Sedes>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_sede = rs.getString("codigo_sede");
                String nombre_sede = rs.getString("nombre_sede");
                String estatus_sede = rs.getString("estatus_sede");

                sede = new Sedes();
                sede.setCodigo_sede(codigo_sede);
                sede.setNombre_sede(nombre_sede);
                sede.setEstatus_sede(estatus_sede);

                sedes.add(sede);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return sedes;
    }

    public int insert(Sedes sedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, sedes.getCodigo_sede());
            stmt.setString(2, sedes.getNombre_sede());
            stmt.setString(3, sedes.getEstatus_sede());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
 public int update(Sedes sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, sede.getCodigo_sede());
            stmt.setString(2, sede.getNombre_sede());
            stmt.setString(3, sede.getEstatus_sede());
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    public int delete(Sedes sedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, sedes.getCodigo_sede());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Sedes query(Sedes sedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, sedes.getCodigo_sede());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_sede = rs.getString("codigo_sede");
                String nombre_sede = rs.getString("nombre_sede");
                String estatus_sede = rs.getString("estatus_sede");

                sedes = new Sedes();
                sedes.setCodigo_sede(codigo_sede);
                sedes.setNombre_sede(nombre_sede);
                sedes.setEstatus_sede(estatus_sede);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return sedes;
    }
}
