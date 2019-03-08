package com.mrhmt.dao;

import com.mrhmt.models.HocSinh;
import com.mrhmt.models.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HocSinhDAO {
    public List<HocSinh> readAll() throws SQLException {
        List<HocSinh> listItem = new ArrayList<HocSinh>();
        MyConnection init = new MyConnection();
        try {
            init.init();
            Statement stmt = null;
            stmt = init.getConn().createStatement();
            String sql;
            sql = "SELECT * FROM hocsinhs";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                HocSinh item = new HocSinh(id, name);
                listItem.add(item);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            init.getConn().close();
        }

        return listItem;
    }

    public HocSinh read(int id) throws SQLException {
        MyConnection init = new MyConnection();

        try {
            init.init();
            String sql;
            sql = "SELECT * FROM hocsinhs WHERE id = ?";
            PreparedStatement preparedStatement = init.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int _id = rs.getInt("id");
                String _name = rs.getString("name");
                HocSinh item = new HocSinh(_id, _name);

                return item;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            init.getConn().close();
        }

        return null;
    }

    public void create(HocSinh obj) throws SQLException {
        MyConnection init = new MyConnection();

        try {
            init.init();
            String sql;
            sql = "INSERT INTO hocsinhs(name) VALUES(?)";
            PreparedStatement preparedStatement = init.getConn().prepareStatement(sql);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            init.getConn().close();
        }
    }

    public void update(HocSinh obj) throws SQLException {
        MyConnection init = new MyConnection();

        try {
            init.init();
            String sql;
            sql = "UPDATE hocsinhs SET name = ? WHERE id = ?";
            PreparedStatement preparedStatement = init.getConn().prepareStatement(sql);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            init.getConn().close();
        }
    }

    public void delete(int id) throws SQLException {
        MyConnection init = new MyConnection();

        try {
            init.init();
            String sql;
            sql = "DELETE FROM hocsinhs WHERE id = ?";
            PreparedStatement preparedStatement = init.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            init.getConn().close();
        }
    }
}
