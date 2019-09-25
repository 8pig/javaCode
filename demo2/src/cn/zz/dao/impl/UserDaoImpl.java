package cn.zz.dao.impl;

import cn.zz.util.JDBCUtil;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
            res = stmt.executeQuery(sql);
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

}
