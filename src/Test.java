import java.util.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int mathCount = 0;
        int scienceCount = 0;
        while (mathCount + scienceCount < 3) {
            System.out.print(UserQuestions.askToJoin);
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals("N")) {
                continue;
            } else if (answer.equals("Y")) {
                try {
                    Student student = new Student();
                    System.out.print(UserQuestions.askFirstName);
                    String firstName = scanner.nextLine();
                    student.setFirstName(firstName);

                    System.out.print(UserQuestions.askLastName);
                    String lastName = scanner.nextLine();
                    student.setLastName(lastName);

                    System.out.print(UserQuestions.askAge);
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    Permission.checkAge(age);
                    student.setAge(age);

                    System.out.print(UserQuestions.askGender);
                    String gender = scanner.nextLine().toUpperCase();
                    student.setGender(gender);

                    System.out.print(UserQuestions.askClassName);
                    String className = scanner.nextLine().toUpperCase();
                    if (className.equals("MATH")) {
                        student.setClassName("Math");
                        mathCount++;

                    } else if (className.equals("SCIENCE")) {
                        student.setClassName("Science");
                        scienceCount++;

                    } else {
                        Permission.checkClassName(className);
                    }
                    students.add(student);
                    System.out.println("Congratulations! You are registered for " + className + " class." + "\n");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid answer.");
            }
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }

        System.out.println("Math students = " + mathCount);
        System.out.println("Science students = " + scienceCount);
    }
}
