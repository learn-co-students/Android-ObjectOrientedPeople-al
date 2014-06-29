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

    public Person(String name, Integer height, Integer age, boolean isFemale, ArrayList<Person> friends){
        mHeight = height;
        mAge = age;
        mName = name;
        this.isFemale = isFemale;
        mFriends = friends;
    }


}
