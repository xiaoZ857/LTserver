package com.example.ltserver;

public class JDBCSaveTest {
    public static void main(String[] args) {
        //测试添加数据到数据库
        UserDao ud = new UserDaoImpl();
        User u = new User();
        u.setUsername("zzh3");
        u.setEmail("zzh3@qq.com");
        u.setPassword("222222");
        boolean flag = ud.save(u);
        if(flag){
            System.out.println("测试：数据添加到数据库成功！");
        }else{
            System.out.println("测试：数据添加到数据库失败！");
        }
    }

}
