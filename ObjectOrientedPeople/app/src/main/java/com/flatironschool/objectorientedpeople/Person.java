package com.flatironschool.objectorientedpeople;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by altyus on 6/27/14.
 */
public class Person {

    Float mHeight;
    Integer mAge;
    String mName;
    boolean isFemale;
    ArrayList<Person> mFriends;

    public Float getHeight() {
        return mHeight;
    }

    public void setHeight(Float height) {
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

    public Person(String name, Float height, Integer age, boolean isFemale, ArrayList<Person> friends){
        mHeight = height;
        mAge = age;
        mName = name;
        this.isFemale = isFemale;
        mFriends = friends;
    }

    public Float grow(){
        if (isFemale)
        {
            if (mAge < 11)
            {
                mHeight = mHeight + randomFloat(0.0f, 1.0f);
            }
            else if (mAge >= 11 && mAge <=15)
            {
               mHeight = mHeight + randomFloat(.5f, 2.0f);
            }
        }
        else
        {
            if (mAge  < 12)
            {
                mHeight = mHeight + randomFloat(0.0f, 1.0f);
            }
            else if (mAge >=12 && mAge <= 16)
            {
                mHeight = mHeight  + randomFloat(0.5f, 3.5f);
            }
        }

        return mHeight;
    }

    private Float randomFloat(Float start, Float end){
        Random rand = new Random();

        return (rand.nextFloat() * (end - start)) + start;
    }

    public void addFriend(Person friend){
        mFriends.add(friend);
    }

    public void addFriends(Person[] friends){
       ArrayList<Person> friendsList = new ArrayList<Person>(Arrays.asList(friends));
        mFriends.addAll(friendsList);
    }

    public boolean removeFriend(Person friend){
        return mFriends.remove(friend);
    }

    public Person[] removeFriends(Person[] friends){
        ArrayList<Person>foundFriends = new ArrayList<Person>();

        for (Person friend: friends){
            if (mFriends.contains(friend)){
                foundFriends.add(friend);
                mFriends.remove(friend);
            }
        }

        //return fizzBuzzList.toArray(new String[fizzBuzzList.size()]);
        return foundFriends.toArray(new Person[foundFriends.size()]);
    }

    public String generatePartyList() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Person friend :mFriends){
            if (stringBuilder.length() > 0){
                stringBuilder.append(", ");
            }
            stringBuilder.append(friend.getName());
        }
        return stringBuilder.toString();
    }
}
