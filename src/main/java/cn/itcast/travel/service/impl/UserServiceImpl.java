package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /*
    * 注册用户
    * */
    @Override
    public Boolean regist(User user) {
        String username = user.getUsername();
        System.out.println(username);
        // 根据用户名查用户对象
        User u1 = userDao.findByUsername(username);
        if(u1 != null){
            // 用户名存在
            return  false;
        }
        // 保存用户信息
        int succNum = userDao.save(user);
        return true;

    }
}
