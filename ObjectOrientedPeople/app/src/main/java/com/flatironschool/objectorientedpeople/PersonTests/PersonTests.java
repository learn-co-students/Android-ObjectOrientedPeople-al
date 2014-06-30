package com.flatironschool.objectorientedpeople.PersonTests;

import android.test.InstrumentationTestCase;

import com.flatironschool.objectorientedpeople.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by altyus on 6/27/14.
 */
public class PersonTests extends InstrumentationTestCase {

    Person mPersonAl;
    Person mPersonAlicia;

    Float alGrowth, aliciaGrowth;

    @Override
    protected void setUp() {
        String name = "Al";
        Float height = 72.0f;
        Integer age = 27;
        boolean isfemale = false;


        ArrayList<Person> friends= new ArrayList<Person>();

        friends.add(new Person("Joe", 74.0f, 25, false, new ArrayList<Person>()));
        friends.add(new Person("Avi", 68.0f, 29, false, new ArrayList<Person>()));
        friends.add(new Person("Arel", 73.0f, 28, false, new ArrayList<Person>()));

        mPersonAl = new Person(name, height, age, isfemale,friends);

        mPersonAlicia = new Person("Alicia", 62.0f, 12, true, friends);
    }

    public void testPersonInstantiation() throws Exception {
        assertNotNull(mPersonAl);
        assertEquals(mPersonAl.getClass(), Person.class);

        assertTrue(mPersonAl.getAge() == 27);
        assertEquals(mPersonAl.getName(), "Al");
        assertTrue(mPersonAl.getHeight() == 72);
        assertFalse(mPersonAl.isFemale());
    }

    public void testGrowGirlTen() throws Exception {
        //should grow a random amount between 0 and 1 inch if person is a girl less than 11 years old



        mPersonAlicia.setAge(10);
        mPersonAlicia.setHeight(62.0f);
        aliciaGrowth = mPersonAlicia.grow();
        assertEquals(aliciaGrowth.getClass(), Float.class);
        assertNotNull(aliciaGrowth);
        assertTrue(mPersonAlicia.getHeight() >= 62 && mPersonAlicia.getHeight() <= 63);
    }
    public void testGrowGirlEleven() throws Exception {
        //should grow a random amount between .5 and 2 inches if person is a girl 11 or older and 15 or younger

        mPersonAlicia.setAge(11);
        mPersonAlicia.setHeight(62.0f);
        aliciaGrowth = mPersonAlicia.grow();
        assertEquals(aliciaGrowth.getClass(), Float.class);
        assertNotNull(aliciaGrowth);
        assertTrue(mPersonAlicia.getHeight() >= 62.5 && mPersonAlicia.getHeight() <= 64);
    }
    public void testGrowGirlSixteen() throws Exception {
        //should grow 0 inches if person is a girl older than 15

        mPersonAlicia.setAge(16);
        mPersonAlicia.setHeight(62.0f);
        aliciaGrowth = mPersonAlicia.grow();
        assertEquals(aliciaGrowth.getClass(), Float.class);
        assertNotNull(aliciaGrowth);
        assertTrue(mPersonAlicia.getHeight() == 62);
    }
    public void testGrowBoyEleven() throws Exception {
        //should grow a random amount between 0 and 1 inch if person is a boy less than 12 years old

        mPersonAl.setAge(11);
        mPersonAl.setHeight(72.0f);
        alGrowth = mPersonAl.grow();
        assertEquals(alGrowth.getClass(), Float.class);
        assertNotNull(alGrowth);
        assertTrue(mPersonAl.getHeight() >= 72 && mPersonAl.getHeight() <= 73);
    }
    public void testGrowBoyTwelve() throws Exception {
        //should grow a random amount between .5 and 3.5 inches if person is a boy 12 years or older and 16 years or younger

        mPersonAl.setAge(12);
        mPersonAl.setHeight(72.0f);
        alGrowth = mPersonAl.grow();
        assertEquals(alGrowth.getClass(), Float.class);
        assertNotNull(alGrowth);
        assertTrue(mPersonAl.getHeight() >= 72.5 && mPersonAl.getHeight() <= 75.5);
    }
    public void testGrowBoySeventeet() throws Exception {

        //should grow 0 inches if person is a boy older than 16

        mPersonAl.setAge(17);
        mPersonAl.setHeight(72.0f);
        alGrowth = mPersonAl.grow();
        assertEquals(alGrowth.getClass(), Float.class);
        assertNotNull(alGrowth);
        assertTrue(mPersonAl.getHeight() == 72);

    }

    public void testAddFriend() throws Exception {
        Person jim = new Person("Jim", 72.0f, 26, false, new ArrayList<Person>());
        Person chris = new Person("Chris", 82.0f, 22, false, new ArrayList<Person>());

        assertTrue(jim.getFriends().size() == 0);
        assertEquals(jim.getFriends().getClass(), ArrayList.class);

        jim.addFriend(chris);

        assertTrue(jim.getFriends().size() == 1);
        assertTrue(jim.getFriends().contains(chris));
    }

    public void testAddFriends() throws Exception {
        Person jim = new Person("Jim", 72.0f, 26, false, new ArrayList<Person>());
        Person chris = new Person("Chris", 82.0f, 22, false, new ArrayList<Person>());
        Person dave = new Person("Dave", 80.0f, 21, false, new ArrayList<Person>());
        Person erica = new Person("Erica", 75.0f, 28, true, new ArrayList<Person>());

        Person [] friends = new Person []{chris, dave, erica};

        jim.addFriends(friends);

        assertTrue(jim.getFriends().contains(chris));
        assertTrue(jim.getFriends().contains(dave));
        assertTrue(jim.getFriends().contains(erica));
        assertEquals(jim.getFriends().size(), 3);

    }

    public void testRemoveFriend() throws Exception {
        Person chris = new Person("Chris", 82.0f, 22, false, new ArrayList<Person>());
        Person dave = new Person("Dave", 80.0f, 21, false, new ArrayList<Person>());
        Person erica = new Person("Erica", 75.0f, 28, true, new ArrayList<Person>());

        ArrayList<Person> friends = new ArrayList<Person>();
        friends.add(chris);
        friends.add(dave);
        friends.add(erica);

        Person jim = new Person("Jim", 72.0f, 26, false, friends);

        assertTrue(jim.removeFriend(chris));

        assertEquals(jim.getFriends().size(), 2);
        assertFalse(jim.getFriends().contains(chris));
        assertTrue(jim.getFriends().contains(dave));
        assertTrue(jim.getFriends().contains(erica));

        jim.removeFriend(erica);

        assertEquals(jim.getFriends().size(), 1);
        assertFalse(jim.getFriends().contains(chris));
        assertFalse(jim.getFriends().contains(erica));
        assertTrue(jim.getFriends().contains(dave));

    }

    public void testRemoveFriends() throws Exception {
        Person chris = new Person("Chris", 82.0f, 22, false, new ArrayList<Person>());
        Person dave = new Person("Dave", 80.0f, 21, false, new ArrayList<Person>());
        Person erica = new Person("Erica", 75.0f, 28, true, new ArrayList<Person>());

        ArrayList<Person> friends = new ArrayList<Person>();
        friends.add(chris);
        friends.add(dave);
        friends.add(erica);

        Person jim = new Person("Jim", 72.0f, 26, false, friends);

        Person[] removedFriends = jim.removeFriends(new Person[]{chris, dave});
        assertEquals(removedFriends.getClass(), (new Person[]{}).getClass());
        assertEquals(removedFriends.length, 2);
        assertTrue(Arrays.deepEquals(new Person[]{chris, dave}, removedFriends));

        assertTrue(jim.getFriends().size() == 1);

        Person[] remainingFriends = jim.getFriends().toArray(new Person[jim.getFriends().size()]);

        assertTrue(Arrays.deepEquals(new Person[]{erica}, remainingFriends));
    }

    public void testGeneratePartyList() throws Exception {
        Person chris = new Person("Chris", 82.0f, 22, false, new ArrayList<Person>());
        Person dave = new Person("Dave", 80.0f, 21, false, new ArrayList<Person>());
        Person erica = new Person("Erica", 75.0f, 28, true, new ArrayList<Person>());

        ArrayList<Person> friends = new ArrayList<Person>();
        friends.add(chris);
        friends.add(dave);
        friends.add(erica);

        Person jim = new Person("Jim", 72.0f, 26, false, friends);

        String partyList = jim.generatePartyList();

        assertNotNull(partyList);
        assertEquals(partyList.getClass(), String.class);

        String expectedPartyList = "Chris, Dave, Erica";
        assertEquals(expectedPartyList, partyList);
    }


    @Override
    protected void tearDown() {

    }
}
