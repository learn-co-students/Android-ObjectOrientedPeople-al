package com.flatironschool.objectorientedpeople.PersonTests;

import android.test.InstrumentationTestCase;

import com.flatironschool.objectorientedpeople.Person;

import java.util.ArrayList;

/**
 * Created by altyus on 6/27/14.
 */
public class PersonTests extends InstrumentationTestCase {

    Person mPerson;

    @Override
    protected void setUp() {
        String name = "Al";
        Integer height = 72;
        Integer age = 27;
        boolean isfemale = false;

        ArrayList<Person> friends= new ArrayList<Person>();

        friends.add(new Person("Joe", 74, 25, false, new ArrayList<Person>()));
        friends.add(new Person("Avi", 68, 29, false, new ArrayList<Person>()));
        friends.add(new Person("Arel", 73, 28, false, new ArrayList<Person>()));

        mPerson = new Person(name, height, age, isfemale,friends);
    }

    public void testPersonInstantiation() throws Exception {
        assertNotNull(mPerson);
        assertEquals(mPerson.getClass(), Person.class);

        assertTrue(mPerson.getAge() == 27);
        assertEquals(mPerson.getName(), "Al");
        assertTrue(mPerson.getHeight() == 72);
        assertFalse(mPerson.isFemale());
    }


    @Override
    protected void tearDown() {

    }
}
