import java.util.ArrayList;

public class StudentManager
{
    
}

abstract class Person
{
    public Person(String name, String email)
    {

    }

    //getters and setters

    //abstract method will be overridden by subclasses (runtime polymorphism)
    public abstract String displayInfo();
}

class Student extends Person
{
    public Student(String name, String email, String id, ArrayList<String> classes)
    {
        super(name, email);
    }

    @Override public String displayInfo()
    {
        return "";
    }
}

class Instructor extends Person
{
    public Instructor(String name, String email)
    {
        super(name, email);
    }

    @Override public String displayInfo()
    {
        return "";
    }
}
