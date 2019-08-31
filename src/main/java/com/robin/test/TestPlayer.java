package com.robin.test;

import com.google.common.collect.Lists;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TestPlayer {


    public static void main(String[] args) {

        test1();
        test2();
    }

    public static void test1(){

        List<Player> list = Lists.newArrayList();
        list.add(new Player("kobe","lakers",31,30000));
        list.add(new Player("james","lakers",34,33000));
        list.add(new Player("pau1","rocket",34,20000));
        list.add(new Player("hardon","rocket",31,20000));
        List<String> names = Lists.newArrayList();
        for(Player player:list){
            names.add(player.getName());
        }
        for(String name:names){
            System.out.println(name);
        }

    }
    public static void test2(){

        List<Player> list = Lists.newArrayList();
        list.add(new Player("kobe","lakers",31,30000));
        list.add(new Player("james","lakers",34,33000));
        list.add(new Player("pau1","rocket",34,20000));
        list.add(new Player("hardon","rocket",31,20000));

        List<String> names = list.stream().map(Player::getName).collect(Collectors.toList());
        names.forEach(System.out::println);

        list.forEach(s->s.setScore(s.getScore() + 1000));
        list.stream().map(Player::getScore).collect(Collectors.toList()).forEach(System.out::println);

        list.stream()
                .filter(p->p.getScore() > 3000)
                .filter((p ->p.getAge()<32))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        list.stream()
                .sorted((p1,p2)->(p1.getScore()-p2.getScore()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        LocalDate today = LocalDate.now();
        System.out.println("今天的时间是：" + today);

        System.out.println("年：" + today.getYear() + "月："+ today.getMonthValue() + "日：" + today.getDayOfMonth());


        LocalTime locat = LocalTime.now();
        System.out.println("the localTime is:" + locat);
        System.out.println("两小时之后的时间是：" + locat.plusHours(2));

        Clock clock = Clock.systemUTC();
        System.out.println("当前时区的顺势时间是："+ clock.instant());
        System.out.println("当前的默认时区时间是：" + Clock.systemDefaultZone().instant());

        String dayAfterTomorrow = "20160414";
        LocalDate formatted = LocalDate.parse(dayAfterTomorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("格式化后的日期是:"+formatted);

        String goodFriday = "04 14 2016";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate holiday = LocalDate.parse(goodFriday,formatter);
        System.out.println("抓换成功后的日期是："+ holiday);

        String utcTime = LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("the utc Time is:" +utcTime);
    }





}
