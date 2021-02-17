/* Author's name: Truc Phan
 * Class: CS 49J
 * Date created: 10/29/2020
 * Description: This program reads a Java source file as an argument,
 * produces an index of all identifiers in the file, and prints all
 * the lines in which it occurs
 * Citation: Java.io.LineNumberReader Class
 * (https://www.tutorialspoint.com/java/io/java_io_linenumberreader.htm)
 * Java - Regular Expressions
 * (https://www.tutorialspoint.com/java/java_regular_expressions.htm)
 */

import java.io.*;
import java.util.*;

public class E5_15 {
    public static void main(String[] args) throws IOException {
        //set the first argument to "Main.java", or any files
        //args[0] = "Main.java";
        //store the order of identifiers for printing
        ArrayList<String> identifierOrder = new ArrayList<>();
        //store the source file for printing later
        ArrayList<String> sourceFile = new ArrayList<>();
        //store the identifier and the lines in which they are found
        HashMap<String, ArrayList<String>> identifierMap = new HashMap<>();

        //create a file
        FileReader fileReader = new FileReader(args[0]);
        //create LineNumberReader object to read the whole line
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        String line; //store each line in Main.java

        //start reading the file
        while ((line = lineNumberReader.readLine()) != null) {
            sourceFile.add(line); //add each source file line to the array list
            //use delimiter to only read letters, numbers, and underscores
            //in the line as an identifier
            Scanner sc = new Scanner(line).useDelimiter("[^A-Za-z0-9_]+");

            //start reading each line
            while (sc.hasNext()) {
                //get an identifier
                String identifier = sc.next();
                //check if the map already contains the identifier
                if (!identifierMap.containsKey(identifier)) {
                    //if not, add identifier to the ArrayList to preserve
                    //their order
                    identifierOrder.add(identifier);
                    //also, add the identifier to the map, and create an
                    //array list for the lines that contain that identifier
                    identifierMap.put(identifier, new ArrayList<String>());
                }
                //add current line to the map with its corresponding identifier
                identifierMap.get(identifier).add(line);
            }
        }

        //print the results on the console
        System.out.println("File read ("+args[0]+"):");
        //print source file
        for (int i=0; i< sourceFile.size(); i++)
            System.out.println(sourceFile.get(i));

        System.out.println("The Output of the Reading Program " +
                "(index: \"identifier\" occurs in: \"lines\")");
        //looping through the array list containing the order of identifiers
        for (int i=0; i<identifierOrder.size(); i++) {
            System.out.println(i+": \""+identifierOrder.get(i)+"\" occurs in:");
            //looping through the array list containing the map values to print
            //line by line
            for (String printLine : identifierMap.get(identifierOrder.get(i)))
                System.out.println(printLine);
            System.out.println();
        }
    }
}
