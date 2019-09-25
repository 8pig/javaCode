package cn.zz.dao.impl;

import java.sql.SQLException;

public interface UserDao {

    /* */
    void findAll () throws SQLException;
    /* 登陆 */
    public void login(String username, String password);
}
