import java.util.Scanner;

public class UI {

    public static void main(String args[]) {
        String type, ans, name;
        float weight, gradeReceived;
        Scanner sc = new Scanner(System.in);
        boolean add = true;
        boolean stay = true;

        System.out.println("Welcome to CKM's Grade Calculator.");
        System.out.println("Please enter the name of your course:");
        name = sc.nextLine();
        Course course = new Course(name);

        while (add) {
            System.out.println("Please enter the type of your work (e.g. midterms, assignments...):");
            type = sc.nextLine();

            System.out.println("Please enter the weight of your " + type + ":");
            weight = sc.nextFloat();

            System.out.println("Please enter the grade received for your " + type + ":");
            gradeReceived = sc.nextFloat();

            course.addGrade(weight, gradeReceived, type);

            System.out.println("Is there another part of the grading scheme you would like to add? Enter y/n:");
            ans = sc.nextLine(); //while loop executing before this command, jumping directly to else statement

            while (stay) {
                if (ans.equals("y") || ans.equals("n"))
                    stay = false;
                else {
                    System.out.println("Invalid input. Enter y/n:");
                    ans = sc.nextLine();
                    stay = true;
                }

                switch (ans) {
                case "y":
                    break;
                case "n":
                    add = false;
                    break;
                }
            }
            /*
             * if(ans.equals("y") stay = false; else if(ans.equals("n")) { stay = false; add
             * = false; } else { System.out.println("Invalid input. Enter y/n:"); ans =
             * sc.nextLine(); stay = true; }
             */

        }

        course.calculateGrades();
        System.out.println("");
        System.out.println("Thank you for using CKM's Grade Calcutor!");
        sc.close();
    }
}