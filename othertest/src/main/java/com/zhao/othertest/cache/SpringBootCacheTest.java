package com.zhao.othertest.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testOne(){
        //走查询逻辑
        System.out.println("第一次查询");
        System.out.println(userDao.getUser(1L));
        //这次直接从缓存取
        System.out.println("第二次查询");
        System.out.println(userDao.getUser(1L));
        //删除了缓存
        userDao.removeFromCache(1L);// 移除缓存
        //走的查询逻辑
        System.out.println("第三次查询");
        System.out.println(userDao.getUser(1L));// 没有缓存了

        System.out.println("--------------");
        // 测试不同的key缓存
        System.out.println(userDao.getUserByName("micro1"));
        // 指定了参数name 为key 此次读取缓存
        System.out.println(userDao.getUserByName(1L, "micro1"));

        System.out.println("--------------");

        //走查询逻辑
        System.out.println("第一次查询");
        System.out.println(userDao.getUser2(1L));
        //走的查询逻辑
        System.out.println("第二次查询");
        System.out.println(userDao.getUser2(1L));
        //走的查询逻辑
        System.out.println("第三次查询");
        System.out.println(userDao.getUser2(1L));// 没有缓存了

    }
}
