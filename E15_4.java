/* Author's name: Truc Phan
 * Class: CS 49J
 * Date created: 10/29/2020
 * Description: This program allows the user to enter
 * the names of the students and their course grades.
 * The user can also remove students, modify grades,
 * and print all grades. The printout is sorted by name.
 * Citation: None
 */

import java.util.Scanner;
import java.util.TreeMap;

public class E15_4 {
    public static void main(String[] args) {
        char choice; //store user's choice
        boolean menu = true; //flag to keep looping main menu
        Scanner sc = new Scanner(System.in);
        //map of String key and String value to store the student's
        //name and grade
        TreeMap<String, String> students = new TreeMap<String, String>();
        String name, grade; //store the name and grade input

        //start looping menu
        while (menu) {
            System.out.print("\nSelect an option:\n" +
                    "   (a) to add a student\n" +
                    "   (r) to remove a student\n" +
                    "   (m) to modify a grade\n" +
                    "   (p) print all grades\n" +
                    "   (q) to quit\n" +
                    "> ");
            choice = sc.next().charAt(0);
            //convert the user's choice to lower case
            choice = Character.toLowerCase(choice);

            switch (choice) {
                //if the user wants to add a new student
                case 'a':
                    //ask for student's name
                    System.out.print("Enter student name: ");
                    name = sc.next();
                    //ask for student's grade
                    System.out.print("Enter student grade: ");
                    grade = sc.next();
                    //put the pair name:grade to the map
                    students.put(name, grade);
                    break;

                //if the user wants to remove a new student
                case 'r':
                    //ask for student's name
                    System.out.print("Enter student name: ");
                    name = sc.next();
                    //remove the student and his/her grade from the map
                    //by using the remove(key) method
                    students.remove(name);
                    break;

                //if the user wants to modify a new student's grade
                case 'm':
                    //ask for student's name
                    System.out.print("Enter student name: ");
                    name = sc.next();
                    //ask for the new grade
                    System.out.print("Enter new student grade: ");
                    grade = sc.next();
                    //put the pair name:grade to the map
                    //this will overwrite the old grade value
                    students.put(name, grade);
                    break;

                //if the user wants to print all names and grades
                case 'p':
                    //for each loop to loop through every key in the map
                    for (String key : students.keySet()) {
                        //store the value (grade)
                        String value = students.get(key);
                        //print the students' names and grades
                        System.out.println(key + ": " + value);
                    }
                    break;

                //if the user wants to quit
                case 'q':
                    //set flag to false to quit the while loop
                    menu = false;
                    break;

                //default case handling wrong input
                default:
                    System.out.println("Wrong input. Please enter again: ");
            }
        }
    }
}
