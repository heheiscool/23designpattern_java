package com.builder.stream;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.builder.stream
 * @ClassName: Course
 * @Author: chenyang
 * @Description: 课程类(产品类)
 * @Date: 2021/3/13 9:48 AM
 * @Version: 1.0
 */
public class Course {
    private String name;
    private String ppt;
    private String video;
    private String note;

    private String homework;

    public String getName() {
        return name;
    }

    public String getPpt() {
        return ppt;
    }

    public String getVideo() {
        return video;
    }

    public String getNote() {
        return note;
    }

    public String getHomework() {
        return homework;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPpt(String ppt) {
        this.ppt = ppt;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", ppt='" + ppt + '\'' +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", homework='" + homework + '\'' +
                '}';
    }
}
