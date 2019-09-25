package cn.zz.test;

import cn.zz.dao.impl.UserDaoImpl;

import java.sql.SQLException;

public class testUserDao {


    public static void main(String[] args) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.findAll();
        userDao.login("superbaby","12345");
    }

}
