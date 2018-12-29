package com.second.chapter2.interviewquestion2;

/**
 * 单例模式(内部类)
 */
public class ForthInstance {
    private ForthInstance(){}

    private static class Instance{
        private static final ForthInstance instance = new ForthInstance();
    }

    public ForthInstance getInstance(){
        return Instance.instance;
    }

}
