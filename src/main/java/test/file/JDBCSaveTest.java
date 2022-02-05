package test.file;

import com.example.ltserver.User;
import com.example.ltserver.UserDao;

public class JDBCSaveTest {
    public static void main(String[] args) {
        //测试添加数据到数据库
        UserDao ud = new UserDao();
        User u = new User();
        u.setUsername("5");
        u.setEmail("1");
        u.setPassword("3");
        boolean flag = ud.save(u);
        if(flag){
            System.out.println("测试：数据添加到数据库成功！");
        }else{
            System.out.println("测试：数据添加到数据库失败！");
        }
    }

}
