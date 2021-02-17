/* Author's name: Truc Phan
 * Class: CS 49J
 * Date created: 10/29/2020
 * Description: This program allows the user to enter
 * the names of the students, their IDs and their course
 * grades. The user can also remove students, modify grades,
 * and print all grades. For grade changes and removals,
 * lookup is by ID. The printout is sorted by last name
 * (or first name if last name is similar, and IDs if both
 * first name and last name are similar)
 * Citation: None
 */

import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;

public class P15_2 {
    public static void main(String[] args) {
        char choice; //store the user's choice
        boolean menu = true; //flag to keep looping main menu
        Scanner sc = new Scanner(System.in);
        //use a TreeMap to store the student's information (key) and his/her grade (value)
        TreeMap<Student, String> studentsGrade = new TreeMap<Student, String>();
        //use a HashMap to store the student's ID (key) and his/her information (value)
        HashMap<Integer, Student> studentsID = new HashMap<Integer, Student>();
        //store the first name, last name and grade input
        String fName, lName, grade;
        int id; //store the student ID
        Student student; //student object

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
                    //ask for student's first name
                    System.out.print("Enter student first name: ");
                    fName = sc.next();
                    //ask for student's last name
                    System.out.print("Enter student last name: ");
                    lName = sc.next();
                    //ask for student's ID
                    System.out.print("Enter student ID: ");
                    id = sc.nextInt();
                    //check for duplicate ID
                    while (studentsID.containsKey(id)) {
                        //ask user to enter a different ID
                        System.out.print("This ID has been taken. Please enter a different one: ");
                        id = sc.nextInt();
                    }
                    //ask for student's grade
                    System.out.print("Enter student grade: ");
                    grade = sc.next();
                    //create a Student object based on the inputs
                    student = new Student(fName, lName, id);
                    //put the pair Student:grade to the TreeMap
                    studentsGrade.put(student, grade);
                    //put the pair of ID:Student to the HashMap
                    studentsID.put(id, student);
                    break;

                //if the user wants to remove a new student
                case 'r':
                    //ask for student's ID
                    System.out.print("Enter student ID: ");
                    id = sc.nextInt();
                    //check for non-existed ID
                    while (!studentsID.containsKey(id)) {
                        //ask user to enter a different ID
                        System.out.print("This ID does not exist. Please enter again: ");
                        id = sc.nextInt();
                    }
                    //remove the student and his/her grade from both maps
                    //by using the remove(key) method
                    studentsGrade.remove(studentsID.get(id));
                    studentsID.remove(id);
                    break;

                //if the user wants to modify a new student's grade
                case 'm':
                    //ask for student's ID
                    System.out.print("Enter student ID: ");
                    id = sc.nextInt();
                    //check for non-existed ID
                    while (!studentsID.containsKey(id)) {
                        //ask user to enter a different ID
                        System.out.print("This ID does not exist. Please enter again: ");
                        id = sc.nextInt();
                    }
                    //ask for the new grade
                    System.out.print("Enter new student grade: ");
                    grade = sc.next();
                    //update student's grade in the TreeMap
                    studentsGrade.put(studentsID.get(id), grade);
                    break;

                //if the user wants to print all names and grades
                case 'p':
                    ////for each loop to loop through every key in the map
                    for (Student key : studentsGrade.keySet())
                        //print student's full name, ID and grade
                        System.out.println(key.toString() + studentsGrade.get(key));
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
