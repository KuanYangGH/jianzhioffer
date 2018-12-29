package com.second.chapter2.interviewquestion2;

/**
 * 单例模式(支持多线程)
 */
public class ThirdInstance {

    private static ThirdInstance instance;

    private ThirdInstance() {
    }

    public ThirdInstance getInstance(){
        if(instance==null){
            synchronized (ThirdInstance.class){
                if(instance==null){
                    return new ThirdInstance();
                }
            }
        }
        return instance;
    }
}
