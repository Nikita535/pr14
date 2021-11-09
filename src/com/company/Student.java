package com.company;

import java.util.Objects;

public class Student implements StudentInt{

    private String name;
    private int age;
    private int group;
    private int res;


    public boolean equals(int res) {
         return this.res==res;
    }


    public Student(String name, int age, int group, int res){
        this.name=name;
        this.age=age;
        this.group=group;
        this.res=res;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public void setRes(int res) {
        this.res = res;
    }

    public int getGroup(){
        return this.group;
    }

    public int getRes(){
        return res;
    }
}