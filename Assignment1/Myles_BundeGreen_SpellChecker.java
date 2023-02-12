import java.util.Scanner;
import java.io.*;

public class Myles_BundeGreen_SpellChecker{

    public static void main(String[] args){
        BagInterface<String> myDictionary = new Myles_BundeGreen_WordsBag<>();
        int wordCount = 0;
        Scanner keyboard = new Scanner(System.in);
        File inputFile = new File("dictionary.txt");
        
        try{
            Scanner fileData = new Scanner(inputFile);
            while(fileData.hasNextLine()){
                String line = fileData.nextLine();
                if(myDictionary.add(line)){
                    wordCount++;
                }
            }
            fileData.close();
            System.out.println(wordCount);
        }
         catch(FileNotFoundException e){
            System.out.println("File not found");
         }
        boolean check = true;
        while(check){
         System.out.println("Please enter a word to check:");
         String word = keyboard.nextLine();

            if(myDictionary.contains(word)){
                System.out.println("You have spelled " + word + " correctly");
            }
            else{
                System.out.println("You have spelled " + word + " wrong or " + word + " isn't in the list of checked words.");
            }
            System.out.println("Would you like to check another word? (1 for yes, 0 for no)");
            int another = keyboard.nextInt();
            keyboard.nextLine();
            if(another == 0){
                check = false;
            }
        }
    }
}