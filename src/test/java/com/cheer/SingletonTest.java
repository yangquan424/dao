package com.cheer;

/**
 * 单例模式是一种设计模式，java一共有23种设计模式
 * 特点：整个系统里有且仅有一个实例
 * 优点：系统的资源得到了很好的重复利用，节省了资源开销
 * 使用场景：数据库连接资源
 */
public class SingletonTest {
    private volatile static  SingletonTest singletonTest = new SingletonTest();

    private SingletonTest(){}

    public static SingletonTest gstSingletonTest(){
        if (singletonTest == null) {
            synchronized (SingletonTest.class){
                if (singletonTest == null) {
                    singletonTest = new SingletonTest();
                }
            }
        }return singletonTest;
    }
}
