package com.zhao.othertest;

import com.google.common.collect.Lists;
import com.zhao.othertest.pattern.proxy.jdk.JDKDynamicProxy;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test2 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        List<String> collect = list.stream().collect(Collectors.toList());
        collect.addAll( new ArrayList<String>());
        System.out.println(collect);

//        BigDecimal price = new BigDecimal("6.3").subtract(new BigDecimal("6.3"));
//
//        boolean b =false;
//
//
////        BigDecimal num = new BigDecimal("1.11");
////
////        System.out.println(price.compareTo(BigDecimal.ZERO)==0);
////        System.out.println( price.multiply(num).setScale(0, BigDecimal.ROUND_DOWN).longValue());
////
////        System.out.println(BigDecimal.class.getClassLoader());
////
////        System.out.println(String.class.getClassLoader());
////
////        System.out.println(Test2.class.getClassLoader());
////        System.out.println(Test3.class.getClassLoader());
////        System.out.println(JDKDynamicProxy.class.getClassLoader());
//        System.out.println(new NullPointerException().getMessage());

//        System.out.println(new Date().getTime());

        Test3 test3 = new Test3();

        List listNew = Lists.newArrayList();

        listNew.add("789");
        listNew.add("456");
        listNew.add("123");
        test3.list = listNew;


        listNew.forEach(System.out::println);
        System.out.println("-------------------------------------------");

        test3.list.forEach(System.out::println);

        listNew.add("91012");
        System.out.println("-------------------------------------------");
        test3.list.forEach(System.out::println);

        System.out.println("-------------------------------------------");

        listNew.sort(Comparator.naturalOrder());
        listNew.forEach(System.out::println);
        System.out.println("-------------------------------------------");

        test3.list.forEach(System.out::println);


    }

    public void test(){

        Test2 test2 = new Test2();
        System.out.println(test2);


    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {

        Test2 test2 = new Test2();
        System.out.println(test2);
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        System.out.println(seen);
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

class Test3{
    public List list;
}
