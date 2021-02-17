/* Author's name: Truc Phan
 * Class: CS 49J
 * Date created: 10/29/2020
 * Description: This program describes the Student class
 * which stores the student's first name, last name, and
 * student ID. It implements Comparable class and overrides
 * compareTo, toString, equals, and hashCode methods
 * Citation: None
 */

public class Student implements Comparable<Student> {
    private String firstName, lastName;
    private int id;

    public Student(String firstName, String lastName, int id) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getId() {
        return id;
    }

    @Override
    public int compareTo(Student s) {
        if (this.lastName.toUpperCase().compareTo(s.lastName.toUpperCase()) == 0) {
            if (this.firstName.toUpperCase().compareTo(s.firstName.toUpperCase()) == 0)
                return this.id - s.id;
            return this.firstName.toUpperCase().compareTo(s.firstName.toUpperCase());
        }
        return this.lastName.toUpperCase().compareTo(s.lastName.toUpperCase());
    }

    public String toString() {
        return (firstName+" "+lastName+" (ID="+id+") : ");
    }

    public boolean equals(Student s) {
        return (firstName.toUpperCase().equals(s.firstName.toUpperCase())
                && lastName.toUpperCase().equals(s.lastName.toUpperCase())
                && id==s.id);
    }

    public int hashCode() {
        return id;
    }
}
