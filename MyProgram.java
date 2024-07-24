/*
Name: Sasha M.
Program purpose: encrypting strings from a text file and outputting to another file
Program Name: String Encryption
Date last modified: 5/14/2024
*/

import java.io.*; //importing everything from java input output

public class MyProgram {
    public static void main(String[] args) throws IOException{
        //setting up buffered reader and writer classes
        BufferedReader reader = new BufferedReader(new FileReader("NoteInput.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("NoteOutput.txt"));
        
        String vowels = "aeiou";//vowel string
        String line, secondLine;//setting up variables
        
        while ((line = reader.readLine()) != null) {//iterating through all lines of the file until empty
            System.out.println("INPUT: " + line); //printing output
            
            StringBuilder resultString = new StringBuilder();  //string builders to hold the modified strings
            StringBuilder secondString = new StringBuilder();
            
            int counter = 1;//counter variable to replace the characters
            for(int i = 0; i < line.length(); i++) { //iterating through the input
                
                char currentChar = line.charAt(i);
                
                if(!vowels.contains(String.valueOf(currentChar))) {
                    resultString.append(String.valueOf(counter)); // Convert counter to string
                    counter++;//counter increases
                    secondString.append(currentChar); // Append non-vowel character to second string
                } else {
                    resultString.append(currentChar);//adding to resultstring
                }
            }
            
            // Convert StringBuilder back to String
            line = resultString.toString(); 
            secondLine = secondString.toString(); 
            
            System.out.println("OUTPUT: " + line);//printing output
            System.out.println("Second Result String: " + secondLine.toUpperCase());//output second string
            writer.println(line); //outputting to the file
        }
        //closing  readers and writers
        reader.close();
        writer.close(); 
    }
}
