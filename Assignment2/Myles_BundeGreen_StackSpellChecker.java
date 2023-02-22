import java.util.*;
import java.io.*;

public class Myles_BundeGreen_StackSpellChecker{
    public static void main(String[] args){
        StackInterface<String> myStackDictionary = new Myles_BundeGreen_Words_Stack<>();
            int wordCount = 0;
            Scanner keyboard = new Scanner(System.in);
            File inputFile = new File("dictionary.txt");

            try{
                Scanner fileData = new Scanner(inputFile);
                while(fileData.hasNextLine()){
                    String line = fileData.nextLine();
                    if(myStackDictionary.push(line)){
                        wordCount++;
                    }
                }
            }
            catch(FileNotFoundException e){
                System.out.println("File not found");
            }
            boolean check = true;
            StackInterface<String> temp = new Myles_BundeGreen_Words_Stack<>();
            while(check){
                System.out.println("Please enter word: ");
                String word = keyboard.nextLine();
                try{
                    while(!word.equals(myStackDictionary.peek())){
                    
                    temp.push(myStackDictionary.pop());
                }
                    if(word.equals(myStackDictionary.peek())){
                        System.out.println("You have spelled " + myStackDictionary.peek() + " correctly, good job.");
                    }
                    else{
                        System.out.println("You have spelled " + word + " incorrectly or it isn't in the list");
                        /*System.out.println("Continue?");
                        int another = keyboard.nextInt();
                        keyboard.nextLine();
                        if(another == 0){
                            check = false;
                        }*/
                    }
                
                System.out.println("Continue?");
                int another = keyboard.nextInt();
                keyboard.nextLine();
                if(another == 0){
                    check = false;
                }
            }
            catch(EmptyStackException e){
                continue;
            }
            while(!temp.isEmpty()){
                myStackDictionary.push(temp.pop());
            }
            System.out.println(myStackDictionary.peek());
            }
    }
}