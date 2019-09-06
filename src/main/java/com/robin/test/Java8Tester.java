package com.robin.test;

public class Java8Tester {


    final static String salutation = "Hello";

    public static void main(String[] args) {
        Java8Tester tester = new Java8Tester();

        MathOperation addition = (int a,int b)-> a + b;
        MathOperation subtraction = (a,b)->a-b;
        MathOperation multiplcation = (int a,int b)->{
            return a*b;
        };

        MathOperation division = (int a,int b)->a/b;

        System.out.println("10+5="+tester.operate(10,5,addition));
        System.out.println("10-5="+tester.operate(10,5,subtraction));
        System.out.println("10*5="+tester.operate(10,5,multiplcation));
        System.out.println("10/5="+tester.operate(10,5,division));


        GreetingService greetingService = message -> System.out.println(salutation + message);


        greetingService.sayMessage("liuxiafei");

    }







    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }


    interface MathOperation{
        int operation(int a,int b);
    }



}
