package com.flatironschool.objectorientedpeople;

import java.util.ArrayList;

/**
 * Created by altyus on 6/27/14.
 */
public class Person {

    Integer mHeight;
    Integer mAge;
    String mName;
    boolean isFemale;
    ArrayList<Person> mFriends;

    public Integer getHeight() {
        return mHeight;
    }

    public void setHeight(Integer height) {
        mHeight = height;
    }

    public Integer getAge() {
        return mAge;
    }

    public void setAge(Integer age) {
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean isFemale) {
        this.isFemale = isFemale;
    }

    public ArrayList<Person> getFriends() {
        return mFriends;
    }

    public void setFriends(ArrayList<Person> friends) {
        mFriends = friends;
    }

    public Person(String name, Integer height, Integer age, boolean isFemale, ArrayList<Person> friends){
        mHeight = height;
        mAge = age;
        mName = name;
        this.isFemale = isFemale;
        mFriends = friends;
    }




}
