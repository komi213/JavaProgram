package com.study.tool.Singleton;

public class SingletonLazy {
    private static SingletonLazy instance = null;
    private SingletonLazy() {}
    public static synchronized SingletonLazy getInstance(){
        if (instance == null) instance = new SingletonLazy();
        return instance;
    }
}
