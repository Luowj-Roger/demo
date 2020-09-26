package com.hnisi.demo.test.StringTest;

public class StringTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int n=3;//放在常量池中，没找到，新建一个
        int m=3;// 从常量池中查找，找到了，直接引用。n，m指向同一个对象

        System.out.println(n==m);

        String str = new String("hello");
        String str1 = new String("hello");// str1 为一个引用
        String str2 = new String("hello");// str2 也是一个引用。虽然str1，str2对象的内容一样，但他们却占着两块地,所以str1==str2 =false


        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));

        str1 = str;
        str2 = str;
        System.out.println(str1==str2);

        String str3 ="hel";
        String str4 = "lo";
        String str5 = "hello";
        String str6 = str3 +str4;//字符串变量相加，编译时无法计算，str5 == str6 返回false
        String str7 = "hel"+"lo";//字符串常量相加，在编译时就会计算结果，str5 == str7 返回ture

        System.out.println(str5==str6);
        System.out.println(str5==str7);
    }
}
