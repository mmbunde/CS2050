import java.util.Scanner;
import java.io.*;

public class Myles_BundeGreen_CLQSpellChecker {
    static DictionaryQueueInterface<String> testQueue = new Myles_BundeGreen_CLQ<>();
    
    public static void main(String[] args){
        //System.out.println("Testing enqueue: " + addTest());
        //System.out.println("Testing clear: " + clearTest());
        int wordCount = 0;
    Scanner keyboard = new Scanner(System.in);
    File inputFile = new File("dictionary.txt");

    try{
        Scanner fileData = new Scanner(inputFile);
        while(fileData.hasNextLine()){
            String line = fileData.nextLine();
            if(testQueue.enqueue(line)){
                wordCount++;
            }
        }
        fileData.close();
    }
    catch(FileNotFoundException e){
        System.out.println("File not found");
    }
    /*System.out.println(testQueue.getFront());
    testQueue.dequeue();
    System.out.println(testQueue.getFront());*/
    DictionaryQueueInterface<String> temp = new Myles_BundeGreen_CLQ<>();
    boolean check = true;

    while(check){
        int count = 1;
        System.out.println("Please enter a word to check the spelling: ");
        String word = keyboard.nextLine();
        try{
            while(!testQueue.isEmpty() && !word.equals(testQueue.getFront())){
                    temp.enqueue(testQueue.dequeue());
            }
            if(!testQueue.isEmpty() && word.equals(testQueue.getFront())){
                System.out.println("You have spelled " + testQueue.getFront() + " correctly, good job.");
            }
            else{
                System.out.println("You have spelled " + word + " incorrectly or it isn't in the list");
            }
            
            System.out.println("Continue? (1 for Yes, 0 for No)");
                int another = keyboard.nextInt();
                keyboard.nextLine();
                if(another == 0){
                    check = false;
                }
        }
        catch(EmptyQueueException e){
            System.out.println("Queue is empty.");
        }
        while(!temp.isEmpty()){
            testQueue.enqueue(temp.dequeue());
        }
    }
    System.out.println("Thank you!");
}

    public static boolean addTest(){
        boolean testAdd = false;
        if(testQueue.isEmpty()){
            testQueue.enqueue("word");
            testAdd = true;
        }
        return testAdd;
    }
    public static boolean clearTest(){
        boolean testClear = false;
        testQueue.clear();
        if(testQueue.isEmpty()){
            testClear = true;
        }
        return testClear;
    }
}