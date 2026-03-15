import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager
{
    public static void main(String[] args)
    {
        //lists
        ArrayList<People> students = new ArrayList<>();
        ArrayList<People> instructors = new ArrayList<>();

        //test students

        ArrayList<String> testCourses1 = new ArrayList<>();
        testCourses1.add("Into to Java");
        testCourses1.add("Web Programming with PHP");
        testCourses1.add("Document Automation Python");
        testCourses1.add("Web Design with CSS");
        testCourses1.add("Communication Technology");
        
        students.add(new Student("Zech Ferguson", "Zech.Ferguson@MyGeorgian.ca", "S-985774985", testCourses1));

        ArrayList<String> testCourses2 = new ArrayList<>();
        testCourses2.add("Into to Java");
        testCourses2.add("Outro to Java");
        
        students.add(new Student("Aiden Piercey", "Aiden.Piercey@MyGeorgian.ca", "S-871239857", testCourses2));

        //hardcoded instructors

        instructors.add(new Instructor("Mr. Elbertson", "JeremyElbertson@georgiancollege.ca"));
        instructors.add(new Instructor("Ms. Cole", "LouisCole@georgiancollege.ca"));
        instructors.add(new Instructor("Mr. Squarepants", "SpongebobSquarepants@georgiancollege.ca"));

        //

        Scanner scanner = new Scanner(System.in);

        //

        System.out.println("\n~~~ WELCOME TO THE STUDENT MANAGER! ~~~\n");

        //running is set to false when you exit
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
                        }
                        //format
                        else if (!emailInput.matches(emailRegex))
                        {
                            System.out.println("ERROR: Email format is incorrect.\n");
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
                        }
                        //format
                        else if (!idInput.matches(idRegex))
                        {
                            System.out.println("ERROR: Student ID format is incorrect.\n");
                        }
                        //if the validation was successful, break the loop
                        else
                            break;
                    }

                    //course input (array)
                    ArrayList<String> coursesInput = new ArrayList<String>();
                    boolean looping = true;
                    while(looping)
                    {
                        System.out.println("Please enter one of their courses:");
                        String courseInput = scanner.nextLine();

                        //validation

                        //empty
                        if(courseInput.isEmpty())
                        {
                            System.out.println("ERROR: Course cannot be blank.\n");
                            continue;
                        }
                        //if the validation was successful, add the course to the arraylist and ask if they'd like to add another
                        else
                        {
                            coursesInput.add(courseInput);

                            //repeat until y or n is typed
                            while(true)
                            {
                                System.out.println("Would you like to add another course? (y/n)");
                                input = scanner.nextLine();

                                if(input.contains("y"))
                                    break;
                                else if(input.contains("n"))
                                {
                                    looping = false;
                                    break;
                                }
                                else
                                    System.out.println("ERROR: Invalid Input.\n");
                            }
                        }
                    }

                    //create the student and add them to the list
                    students.add(new Student(nameInput, emailInput, idInput, coursesInput));

                    System.out.println(nameInput + " has been registered!\n");

                    //return to menu
                break;

                //delete student
                case "2":
                    //print students
                    System.out.println("\n~ STUDENTS: ~");
                    for (People student : students)
                    {
                        student.displayInfo();
                    }

                    System.out.println();

                    //search for student to delete
                    String idInput2;
                    int foundStudentIndex = -1; //default to -1 so that the program knows when no student was found
                    while(true)
                    {
                        System.out.println("Which student would you like to delete? (Enter their student ID)");
                        idInput2 = scanner.nextLine();

                        String idRegex = "^S-[0-9]+$"; //format: S-123456789

                        //validation

                        //empty
                        if(idInput2.isEmpty())
                        {
                            System.out.println("ERROR: Student ID cannot be blank.\n");
                        }
                        //format
                        else if (!idInput2.matches(idRegex))
                        {
                            System.out.println("ERROR: Student ID format is incorrect.\n");
                        }
                        //if the validation was successful, try and find the student
                        else
                        {
                            //run through each student
                            for (int i = 0; i < students.size(); i++)
                            {
                                //check if the student's id matches the inputted one
                                if(((Student)students.get(i)).getID().equalsIgnoreCase(idInput2))
                                {
                                    foundStudentIndex = i;
                                    break;
                                }
                            }

                            //could not find student
                            if(foundStudentIndex == -1)
                                System.out.println("'" + idInput2 + "' did not match any students. Please try again.");
                            //successful
                            else
                            {
                                System.out.println("Successfully deleted " + ((Student)students.get(foundStudentIndex)).getName());

                                //delete the student
                                students.remove(foundStudentIndex);

                                break;
                            }
                        }
                    }

                    //return to menu
                break;

                //search student
                case "3":
                    System.out.println("\n~ SEARCH ~\n");

                    //repeat until a student is found
                    while(true)
                    {
                        System.out.println("Please enter a student's name or student ID");
                        String searchInput = scanner.nextLine();

                        //validation

                        String idRegex = "^S-[0-9]+$"; //format: S-123456789

                        //validation

                        //empty
                        if(searchInput.isEmpty())
                        {
                            System.out.println("ERROR: Name/ID cannot be blank.\n");
                            continue;
                        }

                        //

                        boolean studentFound = false;

                        //if it matches the ID format, it's a student ID
                        if (searchInput.matches(idRegex))
                        {
                            //run through each student
                            for(People student : students)
                            {
                                //check if the ids roughly match
                                if(((Student)student).getID().contains(searchInput))
                                {
                                    System.out.println("\nStudent found!");

                                    ((Student)student).displayInfo();

                                    studentFound = true;

                                    break;

                                    //return to menu
                                }
                            }
                        }
                        //otherwise, it's a name
                        else
                        {
                            //run through each student
                            for(People student : students)
                            {
                                //compare the names in lowercase in order to ignore all casing while using .contains() (so that you don't have to type the entire name)
                                if(((Student)student).getName().toLowerCase().contains(searchInput.toLowerCase()))
                                {
                                    System.out.println("\nStudent found!");

                                    ((Student)student).displayInfo();

                                    studentFound = true;

                                    break;

                                    //return to menu
                                }
                            }
                        }

                        //return to menu if found
                        if(studentFound)
                            break;
                        else
                            System.out.println("ERROR: No students match your search.\n");
                    }
                break;

                //display students and instructors
                case "4":
                    //print students
                    System.out.println("\n~ STUDENTS: ~");
                    for (People student : students)
                    {
                        student.displayInfo();
                    }

                    //print instructors
                    System.out.println("\n~ INSTRUCTORS: ~");
                    for (People instructor : instructors)
                    {
                        instructor.displayInfo();
                    }

                    System.out.println();
                break;

                //exit
                case "5":
                    System.out.println("Goodbye.");
                    running = false;

                    //program ends
                break;

                //invalid input
                default:
                    System.out.println("ERROR: Invalid Input.\n");

                    //repeat menu
                break;
            }
        }

        scanner.close();
    }
}

interface People
{
    //abstract methods will be overridden by subclasses (runtime polymorphism)
    public abstract void displayInfo();
}

abstract class Person implements People
{
    String name;
    String email;

    //constructor
    public Person(String name, String email)
    {
        this.name = name;
        this.email = email;
    }
}

class Student extends Person
{
    String id;
    ArrayList<String> courses = new ArrayList<>();

    //constructor
    public Student(String name, String email, String id, ArrayList<String> courses)
    {
        //inherit parent constructor
        super(name, email);

        this.id = id;
        
        //add each course individually
        for(String course : courses)
            this.courses.add(course);
    }

    //getters

    public String getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }

    //overrides

    @Override public void displayInfo()
    {
        System.out.println(name + " - " + email + " - " + id + "\n     Courses:");

        //print each course
        for (String course : courses)
            System.out.println("          - " + course);
    }
}

class Instructor extends Person
{
    //constructor
    public Instructor(String name, String email)
    {
        //inherit super contrustctor (Instructor class has no unique variables)
        super(name, email);
    }

    //overrides
    
    @Override public void displayInfo()
    {
        System.out.println(name + " - " + email);
    }
}
