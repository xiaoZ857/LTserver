package test.file;

import com.example.ltserver.DBUtil;

import java.sql.Connection;
public class DBtest {
    public static void main(String[] args) {
        //测试连接数据库是否成功
        Connection conn = DBUtil.getConnection();
        if(conn != null){
            System.out.println("测试：数据库连接成功！");
        }else{
            System.out.println("测试：数据库连接失败！");
        }
    }
}
