package com.example.springcloudconsul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 5:11 下午
 **/
@ConfigurationProperties(prefix = "student")
public class StudentConfig {

    private String name;

    private int age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StudentConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
