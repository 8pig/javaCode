package cn.zz.dao;

import cn.zz.domain.User;
import cn.zz.util.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

// 操作数据库中user
public class UserDao {
    // 声明JDBCTemplate 对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /*
     *  登陆方法
     * */
    public User login (User loginUser) {
        // 1 编写sql
        String sql = "select * from user where username = ? and password = ?";
        // 2 调用
        try {
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        }catch(EmptyResultDataAccessException e){
            return null;
        }

    }
}
