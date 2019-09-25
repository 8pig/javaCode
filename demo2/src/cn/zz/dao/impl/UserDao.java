package cn.zz.dao.impl;

import java.sql.SQLException;

public interface UserDao {

    /* */
    void findAll () throws SQLException;
    /* 登陆 */
    public void login(String username, String password);
    public void insert(String username, String password);
    public void delete(int id);
    public void update(int id, String username, String password);
}
