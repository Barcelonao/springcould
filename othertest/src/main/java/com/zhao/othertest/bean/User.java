package com.zhao.othertest.bean;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Component
public class User implements Cloneable{

    @NotNull
    public Integer age;
    public String name;


    public String string[] = {"111", "222", "333"};
    public User user;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object clone(){
        User sc = null;
        try
        {
            sc = (User) super.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return sc;
    }

    public String[] getString() {
        return string;
    }

    public void setString(String[] string) {
        this.string = string;
    }

    public User() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {

        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", string=" + Arrays.toString(string) +
                ", user=" + user +
                '}';
    }
}
