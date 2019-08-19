package cn.zz.login;

import cn.zz.util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            System.out.println(1);
            conn = JDBCUtils.getConnection();
            System.out.println(2);
            String sql = "insert into user (username, password, create_time) values (?,?, now()) ";
            System.out.println(sql+"js");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,"强哥嘎嘎");
            stmt.setString(2,"123456");
            int i;
            i = stmt.executeUpdate();
            System.out.println(i+"sq;");
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }
}
