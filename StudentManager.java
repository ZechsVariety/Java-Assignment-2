import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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
                    System.out.println("\n~ Add a Student ~");

                    //name input
                    String nameInput;
                    while(true)
                    {
                        System.out.println("Please enter their name:");
                        nameInput = scanner.nextLine();

                        //validation

                        //empty
                        if(nameInput.isEmpty())
                        {
                            System.out.println("ERROR: Name cannot be blank.\n");
                            continue;
                        }
                        //if the validation was successful, break the loop
                        else
                            break;
                    }

                    //email input
                    String emailInput;
                    while(true)
                    {
                        System.out.println("Please enter their email:");
                        emailInput = scanner.nextLine();

                        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$"; //[A-Za-z0-9+_.-] matches one or more [A-Z, a-z, 0-9], '_', '.', '-'

                        //validation

                        //empty
                        if(emailInput.isEmpty())
                        {
                            System.out.println("ERROR: Email cannot be blank.\n");
                            continue;
                        }
                        //format
                        else if (!emailInput.matches(emailRegex))
                        {
                            System.out.println("ERROR: Email format is incorrect.\n");
                            continue;
                        }
                        //if the validation was successful, break the loop
                        else
                            break;
                    }

                    //student id input
                    String idInput;
                    while(true)
                    {
                        System.out.println("Please enter their student ID:");
                        idInput = scanner.nextLine();

                        String idRegex = "^S-[0-9]+$"; //format: S-123456789

                        //validation

                        //empty
                        if(idInput.isEmpty())
                        {
                            System.out.println("ERROR: Student ID cannot be blank.\n");
                            continue;
                        }
                        //format
                        else if (!idInput.matches(idRegex))
                        {
                            System.out.println("ERROR: Student ID format is incorrect.\n");
                            continue;
                        }
                        //if the validation was successful, break the loop
                        else
                            break;
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
    String name;
    String email;

    public Person(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

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
