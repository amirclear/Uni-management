package base;

import java.util.ArrayList;

public class Person {
    public int id;
    public static ArrayList<Person> personList = new ArrayList<>();
    public String name;
    public String NationalID;

    public Person(String name, String NationalID) {

        this.name = name;
        this.NationalID = NationalID;
        personList.add(this);
        this.id = personList.size();

    }

    public static Person findById(int id) {

        for (Person person : personList) {
            if (person.id == id) {
                return person;
            }
        }
        return null;

    }
}
