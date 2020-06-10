package com.algorithm.day05;

public class Person {

    Person(){
        System.out.println("初始化Person");
    }

    {
        System.out.println("加载父类代码块");
    }
    static  {
        System.out.println("加载父类静态代码块");
    }


    public static void main(String[] args) {
     // new Woman();
      new Woman.Dog();
        new Woman();
        //现在父类的静态代码块,在加载子的静态代码块,在加载父类代码块,在执行父类构造函数,执行子类代码块,执行子类构造函数

    }



}


class Woman extends Person{

    Woman(){
        System.out.println("初始化Woman");
    }
    {
        System.out.println("加载子类代码块");
    }
    static  {
        System.out.println("加载子类静态代码块");
    }

    static class Dog{
        {
            System.out.println("加载内部类代码块");
        }
        Dog(){
            System.out.println("内部类初始化");
        }
        static {
            System.out.println("内部类静态代码块");
        }
    }
}