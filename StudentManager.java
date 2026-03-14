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
            boolean valid;

            switch(input)
            {
                //add new student
                case "1":
                    System.out.println("\n~ Add a Student ~");

                    //name input

                    System.out.println("Please enter their name:");
                    String nameInput = scanner.nextLine();

                    //email input

                    valid = false;
                    while(!valid)
                    {
                        System.out.println("Please enter their email:");
                        String emailInput = scanner.nextLine();

                        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$"; //[A-Za-z0-9+_.-] matches one or more [A-Z, a-z, 0-9], '_', '.', '-'

                        //check if the email is valid based on the regex above
                        if (emailInput.matches(emailRegex))
                            valid = true;
                        else
                            System.out.println("ERROR: Email is invalid.");
                    }
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
                    System.out.println("ERROR: Invalid Input.\n");
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
    //setters
    public void setEmail(String email)
    {
        
    }

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
