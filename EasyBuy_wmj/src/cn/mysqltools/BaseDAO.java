package cn.mysqltools;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Shinelon on 2017/7/25.
 */
public class BaseDAO {
    private static String driver; // 数据库驱动字符串
    private static String url; // 连接URL字符串
    private static String user; // 数据库用户名
    private static String password; // 用户密码
    private Connection conn = null; // 数据连接对象
    private PreparedStatement ps;
    private ResultSet rs;

    static {
        // 静态代码块，在类加载的时候执行
        init();
    }
    public static void init(){
        Properties params = new Properties();
        String path1 = BaseDAO.class.getResource("").getPath();
        String configFile = path1 + "database.properties"; // 配置文件路径
        File file = new File(configFile);
        // 加载配置文件到输入流中
        InputStream is = null;
        try {
            is = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            // 从输入流中读取属性列表
            params.load(is);

        } catch (IOException e){
            e.printStackTrace();
        }
        // 根据指定的获取对应的值
        driver = params.getProperty("driver");
        url = params.getProperty("url");
        user = params.getProperty("user");
        password = params.getProperty("password");


    }
    public static void main(String[]args){
        System.out.println(driver);
    }

    /**
     * 获取数据库连接
     */
    public Connection getConn(){
        if(conn==null){
            // 获取连接并捕获异常
            try{
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return  conn;      //返回连接对象
    }
    public void closeAll(){
        // 若结果集对象不为空，则关闭
        if(rs!=null){
            try{
                rs.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try{
                ps.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public int executeUpdate(String sql,Object... objs) throws Exception{
        int count=0;
        getConn();
        ps=conn.prepareStatement(sql);
        if(objs!=null){
            for (int i=0; i<objs.length; i++) {
                //һ��item����һ��չλ��������
                ps.setObject(i+1, objs[i]);
            }
            count= ps.executeUpdate();
        }

        return count;
    }


    //04.executeQuery()  ��ѯ
    public ResultSet executeQuery(String sql,Object... objs) throws Exception{
        getConn();
        ps=conn.prepareStatement(sql);
        if(objs!=null){
            for (int i=0; i<objs.length; i++) {
                //һ��item����һ��չλ��������
                ps.setObject(i+1, objs[i]);
            }
            rs= ps.executeQuery();
        }
        return rs;
    }
}
