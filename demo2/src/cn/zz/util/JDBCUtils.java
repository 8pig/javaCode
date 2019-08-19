package cn.zz.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 *   jdbc Durid
 *
 * */
public class JDBCUtils {

    private static DataSource ds;

    static {
        try {
            // 1 加载配置
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            // 2 初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        };
    }
    /*
     *   获取连接 connection 对象
     *
     * */
    public static Connection getConnection () throws SQLException {
        return  ds.getConnection();
    }

    /*
     *   获取连接池对象
     * */
    public static DataSource getDataSource () {
        return  ds;
    }
    /*
    *  释放资源
    * */
    public static void close (Statement stmt, Connection conn){
       close(null,stmt,conn);
    }
    public static void close (ResultSet rs,Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
