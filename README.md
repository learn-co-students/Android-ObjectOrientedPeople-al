

Android Object-Oriented-People 
===============================

## Learning Goals
  1. Learn how Objects work
  2. Get better with Java

## Requirements
  1. Create a new Person Class.  
  2. Add all of the required fields to the Person class 
  3. Implement all of the required methods in the Person class 

### Person

#### About Fields (AKA Instance Variables, AKA Member Variables)
Fields provide a way to store information about a class that is accessible from any method within the class.  Say for instance we created a class called cats.  If Cats has a field (of type Integer) numberOfLegs, we can set number of legs and then access it from any method in our Cats class.  For External access to our  field, we create accessor methods, often known as getters (to get the value of our field) and setters (to set the value of our field). 

```java

 public Integer numberOfLegs(){
 	return numberOfLegs; 
}

```

```java

public void setNumberOfLegs(Integer numberOfLegs){
	this.numberOfLegs = numberOfLegs; 
}

```

We can use these methods to both set and get our class's field values.  Let's say we create a Cat 'myCat' in our Activty's `onCreate()` method.  We can set the cats number of legs and get the cats number of legs using the following code.  

```java

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Cat myCat = new Cat(); 
        myCat.setNumberOfLegs(4); 

        Log.i(TAG, Integer.toString( myCat.getNumberOfLegs() ) ); //Prints 4 
    }

```

Last, remember that the classes you make are just like any other class such as `String` or `Integer`. You can add them to arrays like this:

```java
Cat[] myArray = new Cat[]{new Cat()}; 
```

Then we can get the cats the same way we are used to with arrays

```
Cat retreivedCat = myArray[0];
```

#### Fields
Create the following Fields in Person.java  

  1. ```(Float)mHeight```
  2. ```(Integer)mAge```
  3. ```(String)mName```
  4. ```(boolean) isFemale```
  5. ```(ArrayList<Person>)mFriends```

ex. 
```java

 public class Person {

 Float mHeight; 
 boolean isFemale;
 // More Fields go here  

}
```

#### Methods
  1. ```public Float grow()```
    * Based on age/gender, grow a random amount of inches.
    * If it's a girl with age < 11 grow between 0 and 1 inch, age >= 11 and <=15 grow .5 to 2 inches. >15 grow 0 inches
    * If it's a boy with age < 12 grow between 0 and 1 inch, age >=12 and <=16 grow .5-3.5 inches. >16 grow 0 inches
  2. ```public void addFriends(Person[] friends)```
    * Add the elements of the passed in `Array` to our `friends` field. Return an array of all of the person's friends. 
  3. ```Public String generatePartyList()```
    * Generate a list of friends for an upcoming party. It should look like this: `"eric, chris, al, avi, adam"`
  4. ```public boolean removeFriend(Person friend)```
    * Remove that friend from the array.
    * Return `true` or `false` if they were found or not found

##### Extra Credit

  5. ```public Person[] removeFriends(Person[] friends)```
    * Remove the friends listed in the passed in argument from our current `friends` field.
    * Return an array of friends who were found and removed

#### Playing with your methods in the Activity

Feel free to play with your new class outside of the tests in the PeopleActivity.java file. 

