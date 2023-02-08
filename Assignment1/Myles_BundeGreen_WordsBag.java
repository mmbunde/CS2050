import java.lang.*;
import java.util.zip.CheckedInputStream;
public final class Myles_BundeGreen_WordsBag<T> implements BagInterface<T>{

    private final T[] bag;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 3000;
    private static final int MAX_CAPACITY = 10000;

    public Myles_BundeGreen_WordsBag(){
        this(DEFAULT_CAPACITY); 
    }

    public Myles_BundeGreen_WordsBag(int desiredCapacity){
        if(desiredCapacity <= MAX_CAPACITY){
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        }
        else{
            throw new IllegalStateException("Attempted to create a bag" +
            " whose capacity exceeds the allowed maximum");
        }
    }

    public T[] toArray(){
        checkIntegrity();

        T[] result = (T[]) new Object[numberOfEntries];
        
        for(int index = 0; index < numberOfEntries; index++){
            result[index] = bag[index];
        }
        return result;
    }

    private boolean isArrayFull(){
        return numberOfEntries >= bag.length;
    }

    public boolean add(T newEntry){
        checkIntegrity();
        boolean result = true;
        if(isArrayFull()){
            result = false;
        }
        else{
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    public int getCurrentSize(){
        return numberOfEntries;
    }

    public int getFrequencyOf(T anEntry){
        checkIntegrity();
        int counter = 0;

        for(int index = 0; index < numberOfEntries; index++){
            if(anEntry.equals(bag[index])){
                counter++;
            }
        }
        return counter;
    }

    public boolean contains(T anEntry){
        checkIntegrity();
        boolean found = false;
        int index = 0;
        while(!found && index < numberOfEntries){
            if(anEntry.equals(bag[index])){
                found = true;
            }
            index++;
        }
        return found;
    }

    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }

    public T remove(){
        checkIntegrity();
        T result = null;

        if(numberOfEntries > 0){
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    public boolean remove(T anEntry){
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    private void checkIntegrity(){
        if(!integrityOK){
            throw new SecurityException("Array is corrupt");
        }
    }

    private int getIndexOf(T anEntry){
        int where = -1;
        boolean found = false;
        int index = 0;
        while(!found && index < numberOfEntries){
            if(anEntry.equals(bag[index])){
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    private T removeEntry(int givenIndex){
        T result = null;

        if(!isEmpty() && givenIndex >=0){
            result = bag[givenIndex];
            int lastIndex = numberOfEntries;
            bag[givenIndex] = bag[lastIndex];
            bag[lastIndex] = null;
            numberOfEntries--;
        }

        return result;
    }
    
}