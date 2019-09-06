package com.robin.test;

import com.google.common.base.Charsets;

import java.util.Base64;
import java.util.UUID;

public class Java8Tester2 {

    public static void main(String[] args) {
        String first = "";
        Comparator<String> comparator = (i,j)-> System.out.println(Integer.compare(i.length(),j.length()));

        comparator.com("aaa","bb");


        String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes(Charsets.UTF_8));
        System.out.println("Base64编码字符串："+ base64encodedString);

        byte[] base64decodeBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println("原始字符串："+new String(base64decodeBytes,Charsets.UTF_8));

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<10;i++){
            stringBuilder.append(UUID.randomUUID().toString());
        }
        byte[] mimeBytes = stringBuilder.toString().getBytes(Charsets.UTF_8);
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64编码字符串："+mimeEncodedString);


    }


    public interface Converter<T1,T2>{
        void convert(int i);
    }
    public interface Comparator<T>{
        void com(String a,String b);
    }


}
