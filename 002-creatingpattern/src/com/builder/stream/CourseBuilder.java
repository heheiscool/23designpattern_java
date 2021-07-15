package com.builder.stream;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.builder.stream
 * @ClassName: CourseBuilder
 * @Author: chenyang
 * @Description: 创建建造者类
 * @Date: 2021/3/13 10:01 AM
 * @Version: 1.0
 */
public class CourseBuilder {
    private Course course = new Course();
    public CourseBuilder addName(String name){
        course.setName(name);
        return this;
    }
    public CourseBuilder addPpt(String ppt){
        course.setPpt(ppt);
        return this;
    }
    public CourseBuilder addVideo(String video){
        course.setVideo(video);
        return this;
    }
    public CourseBuilder addNote(String note){
        course.setPpt(note);
        return this;
    }
    public CourseBuilder addHomework(String homgwork){
        course.setHomework(homgwork);
        return this;
    }
    public Course builder(){
        return course;
    }
}
