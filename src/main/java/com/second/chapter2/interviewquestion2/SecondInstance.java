package com.second.chapter2.interviewquestion2;

/**
 * 单例模式(不支持多线程)
 */
public class SecondInstance {

    private static SecondInstance instance;
    private SecondInstance() {
    }

    public SecondInstance getInstance(){
        if(instance==null){
            return new SecondInstance();
        }
        return instance;
    }
}
