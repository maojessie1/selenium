package java20190818;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConnectMySQL1 {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String host;
    private static String username;
    private static String pwd;

    private static Statement stat = null;
    private static Connection conn = null;

    public static void Connect(String host, String username, String pwd) {
        ConnectMySQL1.close();
        ConnectMySQL1.host = host;
        ConnectMySQL1.username = username;
        ConnectMySQL1.pwd = pwd;
    }

    private static void close() {
        try {
            if (stat != null) {
                stat.close();
                stat = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectMysql() {
        try {
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + "?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", username, pwd);
//            conn.createStatement();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void statement() {
        if (conn == null) {
            ConnectMySQL1.connectMysql();
        }
        try {
            stat = (Statement) conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static ResultSet resultSet(String sql) {
        ResultSet rs = null;
        if (stat == null) {
            ConnectMySQL1.statement();
        }

        try {
            rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }


    public static synchronized List<HashMap<String, String>> query(String sql) {
        return ConnectMySQL1.result(sql);
    }


    private static List<HashMap<String, String>> result(String sql) {
        ResultSet rs = ConnectMySQL1.resultSet(sql);
        List<HashMap<String, String>> result = null;

        try {
            result = new ArrayList<HashMap<String, String>>();


            ResultSetMetaData md = rs.getMetaData();
            int cc = md.getColumnCount();
            while (rs.next()) {
                HashMap<String, String> columnMap = new HashMap<>();
                for (int i = 1; i <= cc; i++) {
                    columnMap.put(md.getColumnName(i), rs.getString(i));
                }
                result.add(columnMap);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
