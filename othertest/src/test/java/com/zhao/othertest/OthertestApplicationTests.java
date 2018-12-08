package com.zhao.othertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OthertestApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testOne(){
//        String words[] = new String[]{"hello","world"};
//
//        List<String[]> collect = Arrays.stream(words).map(word -> word.split("")).distinct().collect(Collectors.toList());
//
//        collect.stream().map(str->Arrays.toString(str)).forEach(System.out::print);
//
//        List<String> collect1 = Arrays.stream(words).map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
//
//        collect1.stream().forEach(System.out::print);


        ArrayList<HaHa> haha = new ArrayList<HaHa>();

        haha.add(new HaHa("hahaone","132456"));
        haha.add(new HaHa("hahaone","132456"));
        haha.add(new HaHa("hahaone","132456"));
        haha.add(new HaHa("hahatwo","132456"));
        haha.add(new HaHa("hahatwo","132456"));
        haha.add(new HaHa("hahatwo","132456"));
        haha.add(new HaHa("hahathree","132456"));
        haha.add(new HaHa("hahathree","132456"));
        haha.add(new HaHa("hahathree","132456"));
        haha.add(new HaHa("hahafour","132456"));


        Map<String, List<HaHa>> collect = haha.stream().collect(Collectors.groupingBy(HaHa::getName));

        collect.entrySet().stream().forEach(e-> {
            e.getValue().forEach( System.out::println);
            System.out.println("-----------------");
        });

    }

}
class HaHa{

    private  String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HaHa(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "HaHa{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
