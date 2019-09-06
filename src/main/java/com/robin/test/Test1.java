package com.robin.test;

class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0)
            System.out.println("Disposing " + this);
    }

    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    public String toString() {
        return "Composing " + id;
    }
}

public class Test1 {
    //lambda使用的地方
    //1、遍历集合
    //2、使用匿名内部类
    public static void main(String[] args) {
        sayHello();
    }

    private static void sayHello() {
        MyInterface myInterface = (a, b) -> System.out.println("a:" + a + "b:" + b);
        myInterface.method(1, 2);
    Player player = Player.builder().name("yaoming").team("rocket").age(23).score(1000).build();
        System.out.println("the player is:" + player);
        System.out.println("the player name is:" + player.getName());



}
}








