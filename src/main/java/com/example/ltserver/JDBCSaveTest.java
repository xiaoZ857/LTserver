package com.example.ltserver;

public class JDBCSaveTest {
    public static void main(String[] args) {
        //测试添加数据到数据库
        UserDao ud = new UserDao();
        User u = new User();
        u.setUsername("6");
        u.setEmail("6");
        u.setPassword("6");
        boolean flag = ud.save(u);
        if(flag){
            System.out.println("测试：数据添加到数据库成功！");
        }else{
            System.out.println("测试：数据添加到数据库失败！");
        }
    }

}
