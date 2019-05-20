package com.cheer.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * 为外界连接数据库
 * 为外界关闭数据库资源
 */
public class DcUtils {
    private volatile static DcUtils instance = new DcUtils();

    private DcUtils(){}

    public static DcUtils gstInstance(){
        if (instance == null) {
            synchronized (DcUtils.class){
                if (instance == null) {
                    instance = new DcUtils();
                }
            }
        }return instance;
    }

    /**
     * 与数据库建立连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        String url = loadRrSource().getProperty("url");
        String user = loadRrSource().getProperty("user");
        String password = loadRrSource().getProperty("password");
        String driverClass = loadRrSource().getProperty("driverClass");

        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 获取properties文件
     * @return
     */
    private static Properties loadRrSource(){
        InputStream is = DcUtils.class.getClassLoader().getResourceAsStream("address.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 关闭资源
     * @param conn
     * @param sta
     * @param rt
     */
    public static void close(Connection conn,Statement sta,ResultSet rt) {
        try {
            if(rt!= null) {
                rt.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(sta!=null) {
                    sta.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
