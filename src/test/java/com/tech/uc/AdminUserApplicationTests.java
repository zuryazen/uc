package com.tech.uc;

import com.tech.uc.entity.User;
import com.tech.uc.mapper.UserMapper;
import com.tech.uc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {

        User root = userService.findByUsername("root", "http://127.0.0.1:8080");



    }


    // 测试list转tree结构
    @Test
    public void test() throws Exception {
        List<Demo> list = new ArrayList<>();
        Map<String, Demo> map = new HashMap<>();
        Demo demo1 = new Demo("1", "-1", "基本信息");
        Demo demo2 = new Demo("2", "1", "系统管理");
        Demo demo3 = new Demo("3", "2", "用户管理");
        Demo demo4 = new Demo("4", "2", "角色管理");
        Demo demo5 = new Demo("5", "3", "用户信息");

        list.add(demo4);
        list.add(demo1);
        list.add(demo5);
        list.add(demo3);
        list.add(demo2);

        System.out.println(list2tree(list));
    }
    public static List<Demo> list2tree(List<Demo> list){
        Map<String, Demo> map = new HashMap<>();
        //ID 为 key 存储到map 中
        for (Demo demo : list) {
            map.put(demo.getId(), demo);
        }
        List<Demo> demoList = new ArrayList<>();
        for (Demo demo : list) {
            //子集ID返回对象，有则添加。
            Demo demo1 = map.get(demo.getPid());
            if(demo1 != null){
                demo1.getChildrens().add(demo);
            }else {
                demoList.add(demo);
            }
        }
        return demoList;
    }
}

class Demo {

    private String id;
    private String pid;
    private String name;
    private List<Demo> childrens = new ArrayList<>();


    public Demo() {
    }

    public Demo(String id, String pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.childrens = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Demo> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Demo> childrens) {
        this.childrens = childrens;
    }


    @Override
    public String toString() {
        return "Demo{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", childrens=" + childrens +
                '}';
    }
}