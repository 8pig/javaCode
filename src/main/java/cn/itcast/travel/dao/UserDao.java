package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;


public interface UserDao {
    public User findByUsername (String username);
    /*
    * @param user
    * */
    public int save (User user);
}
