package com.observer.gper;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.gper
 * @ClassName: Question
 * @Author: chenyang
 * @Description: 发布类容
 * @Date: 2021/3/18 3:39 PM
 * @Version: 1.0
 */
public class Question {
    private String userName;
    private String content;

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
