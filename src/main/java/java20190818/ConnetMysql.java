package java20190818;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class ConnetMysql {
    public static String driver =
            "com.mysql.jdbc.Driver";
    private static String host;
    private static String user;
    private static String pwd;
    private static Connection conn = null;
    private static Statement stmt = null;
    public static void connect(String host,String
            user,String password){
        close();
        ConnetMysql.host = host;
        ConnetMysql.user = user;
        ConnetMysql.pwd = password;
    }
    public static synchronized
    List<HashMap<String,String>> query( String sql ){
        return ConnetMysql.result(sql);
    }
    public static synchronized void close(){
        try {
            if( stmt != null ){
                stmt.close();
                stmt = null;
            }
            if( conn != null ){
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
// TODO: handle exception
        }
    }
    private static void conncetMysql(){
        try {
            Class.forName(driver).newInstance();
            conn = (Connection)
                    DriverManager.getConnection("jdbc:mysql://" +
                            host +
                            "?userunicode=true&characterEncoding=UTF8",user,pwd);
        } catch (Exception e) {
            e.printStackTrace();
// TODO: handle exception
        }
    }
    private static void statement(){
        if( conn == null ){
            ConnetMysql.conncetMysql();
        }
        try {
            stmt = (Statement) conn.createStatement();
        } catch (Exception e) {
// TODO: handle exception
        }
    }
    private static ResultSet resultSet(String sql){
        ResultSet rs = null;
        if( stmt == null){
            ConnetMysql.statement();
        }
        try {
            rs = (ResultSet) stmt.executeQuery( sql );
        } catch (Exception e) {
// TODO: handle exception
        }
        return rs;
    }
    public static List<HashMap<String, String>> result(
            String sql){
        ResultSet rs = resultSet(sql);
        List<HashMap<String ,String>> result = new
                ArrayList<HashMap<String ,String>>();
        try{
            ResultSetMetaData md = (ResultSetMetaData)
                    rs.getMetaData();
            int cc = md.getColumnCount();
            while ( rs.next()) {
                HashMap<String,String > columMap =
                        new HashMap<String, String>();
                for( int i = 1; i <= cc ; i++){
                    columMap.put(
                            md.getColumnName(i), rs.getString( i));
                    result.add( columMap );
                }
            }
        }catch( Exception e){
            e.printStackTrace();
        }
        return result ;
    }
    public static void main(String[] args) {
// TODO Auto-generated method stub
        ConnetMysql.connect("127.0.0.1:3306/mysql",
                "root", "zhouxiaoyuan");
        List< HashMap<String, String> > rs =
                ConnetMysql.
                        query( "select * from user" );
        System.out.println( rs.size() );
        System.out.println( rs );
        ConnetMysql.close();
    }
}