package cn.zz.dao.impl;

import cn.zz.util.JDBCUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public void findAll () throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            conn = JDBCUtil.getConn();
            stmt = conn.createStatement();
            String sql = "select * from user";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                String username = res.getString("username");
                String password = res.getString("password");
                System.out.println(username+","+password);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,stmt,res);
        }
    }
    @Override
    public void login (String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            conn = JDBCUtil.getConn();
            stmt = conn.createStatement();
            String sql = "select * from user where username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "username");
            ps.setString(2, "password");

            res = ps.executeQuery();


//            res = stmt.executeQuery(sql);
            if (res.next()) {

                System.out.println(username+","+password);
                System.out.println("登陆成功");
            }else {
                System.out.println("登陆失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            JDBCUtil.release(conn,stmt);
        }
    }

    @Override
    public void insert (String username, String password) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUtil.getConn();
            stmt = conn.createStatement();
            PreparedStatement ps = null;
            String sql = "insert into user values( null, ?, ?, now())";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            int res = ps.executeUpdate();


//            res = stmt.executeQuery(sql);
            if (res > 0) {
                System.out.println(username+","+password);
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            JDBCUtil.release(conn,stmt);
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUtil.getConn();
            stmt = conn.createStatement();
            String sql = "delete from user where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int res = ps.executeUpdate();

            if (res > 0) {
                System.out.println(id);
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            JDBCUtil.release(conn,stmt);
        }
    }

}
