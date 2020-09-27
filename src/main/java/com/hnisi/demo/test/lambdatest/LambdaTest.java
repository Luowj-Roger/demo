package com.hnisi.demo.test.lambdatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lambda 使用
 * @author Roger
 */
public class LambdaTest {
    
    public static void main(String[] args){
        List<String> names = new ArrayList<String>();
        names.add("1");
        names.add("2");
        names.add("3");
        names.add("4");
        names.add("5");
        //未使用Lambda表达式
        Collections.sort(names, new Comparator<String>() {

            public int compare(String o1, String o2) {
                return -1;
            }
        });
        System.out.println(names);
        //使用Lambda表达式，是对匿名比较器的简化
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println(names);
        List<String> list2 = new ArrayList<String>();
        //利用stream().map()处理List，并给另外一个List赋值
        list2 = names.stream().map(string -> {
            return "stream().map()处理之后：" + string;
        }).collect(Collectors.toList());


        //利用stream().filter()处理List,对该List进行过滤处理：
        list2 = names.stream().filter(s -> s != "1").collect(Collectors.toList());

        System.out.println(list2.toString());


    }
}
