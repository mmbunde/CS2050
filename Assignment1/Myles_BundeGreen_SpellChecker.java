import java.util.Scanner;

public class Myles_BundeGreen_SpellChecker{

    public static void main(String[] args){
        BagInterface<String> myDictionary = new Myles_BundeGreen_WordsBag<>();
        int wordCount;
        Scanner fileData = new Scanner(new File(input file));
        try{
            while(fileData.hasNextLine()){
                String line = fileData.nextLine();
                if(myDictionary.add(line)){
                    wordCount++;
                }
            }
        }
        
        
    }
}