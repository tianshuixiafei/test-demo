package com.robin.test;

import com.google.common.base.*;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

class Shared{
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;
    public Shared() {
        System.out.println("Creating "+this);
    }
    public void addRef() {
        refcount++;
    }
    protected void dispose() {
        if(--refcount == 0)
            System.out.println("Disposing "+this);
    }
    public String toString() {
        return "Shared "+id;
    }
}
class Composing{
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;
    public Composing(Shared shared) {
        System.out.println("Creating "+this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose() {
        System.out.println("disposing "+this);
        shared.dispose();
    }
    public String toString() {
        return "Composing "+id;
    }
}
public class Test1 {
    //lambda使用的地方
    //1、遍历集合
    //2、使用匿名内部类
    public static void main(String[]args) {
        sayHello();
    }
    private static void sayHello(){
        String[] stars = {"james","kobe","paul","Anthony","rose","love","Jr","Jordan"};
        List<String> starList = Arrays.asList(stars);
        for(int i=0;i<starList.size();i++){
            System.out.println(starList.get(i));
        }
        for(String str:starList){
            System.out.println(str);
        }
        starList.forEach((star)-> System.out.println(star));
        starList.forEach(System.out::println);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }).start();
        new Thread(()-> System.out.println(1)).start();
        Arrays.sort(stars, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        Arrays.sort(stars,(String s1,String s2)->s1.compareTo(s2));








    }








}