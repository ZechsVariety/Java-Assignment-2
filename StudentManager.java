import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n~~~ WELCOME TO THE STUDENT MANAGER! ~~~\n");

        boolean running = true;
        while(running)
        {
            System.out.println("~ Main Menu ~"
            + "\n1. Add a new student"
            + "\n2. Delete a student"
            + "\n3. Search for a student"
            + "\n4. Display students and teachers"
            + "\n5. Exit");

            String input = scanner.nextLine();

            switch(input)
            {
                //add new student
                case "1":

                break;

                case "2":
                    
                break;

                case "3":
                    
                break;

                case "4":
                    
                break;

                //exit
                case "5":
                    System.out.println("Goodbye.");
                    running = false;
                break;

                //invalid input
                default:
                    System.out.println("ERROR: INVALID INPUT\n");
                break;
            }
        }

        scanner.close();
    }
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
