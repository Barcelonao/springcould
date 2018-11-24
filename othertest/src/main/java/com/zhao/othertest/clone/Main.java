package com.zhao.othertest.clone;

import com.zhao.othertest.bean.User;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User(123, "haha");
        User user1 = new User(456, "xixi");
        user.setUser(user1);

        User user2 = (User) user.clone();
        user2.getUser().setAge(0);
        user2.getString()[0]="1234444444";
        System.out.println(user);
    }
}
