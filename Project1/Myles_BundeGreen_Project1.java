public class Myles_BundeGreen_Project1{
    static BagInterface<String> testLink = new LinkedBag<>();
    
    public static void main(String[] args){
        System.out.println("Testing add: " + add_test());
        System.out.println("Test empty: " + empty_test());
        System.out.println("Test size: " + size_test(12));
        //System.out.println("Test array: " + array_test(4));
    }

    public static boolean add_test(){
        //BagInterface<String> testLink = new LinkedBag<>();
        boolean test_add = false;
        if(testLink.isEmpty()){
            testLink.add("String test");
            test_add = true;
        }
        else{
            test_add = false;
        }
        testLink.add("String 2");
        if(testLink.contains("String test") && testLink.getFrequencyOf("String 2") >= 1){
            test_add = true;
        }
        
        else if(testLink.contains("String test") || testLink.getFrequencyOf("String 2") >= 1){
            test_add = true;
            System.out.println("Conatains is: " + testLink.contains("String test") + " or getFreq is " + testLink.getFrequencyOf("String 2"));
        }

        else{
            test_add = false;
        }
        testLink.clear();
        return test_add;
    }

    public static boolean empty_test(){
        //BagInterface<String> testLink = new LinkedBag<>();
        boolean test_empty = false;
        boolean test_notempty = false;
        //testing if link bag is empty
        if(testLink.isEmpty()){
            test_empty = true;
        }
        else{
            test_empty = false;
        }
        //testing is link bag is not empty
        testLink.add("test empty");
        if(testLink.isEmpty()){
            test_notempty = false;
        }
        else{
            test_notempty = true;
        }
        if(test_empty && test_notempty){
            testLink.clear();
            return true;
        }
        else if(test_empty || test_notempty){
            System.out.println("test_empty is " + test_empty + " test_notempty is" + test_notempty);
            testLink.clear();
            return true;
        }
        else{
            testLink.clear();
            return false;
        }
        
    }
    public static boolean size_test(int size){
        int i;
        boolean test_size = false;
        for(i = 1; i <= size; i++){
            testLink.add("test size " + i);
            System.out.println(testLink);
        }
        if(testLink.getCurrentSize() == size){
            test_size = true;
        }
        else{
            test_size = false;
        }
        testLink.clear();
        return test_size;
    }
    /*public static boolean array_test(int array_length){
        int i;
        boolean test_array;
        for(i = 0; i <= array_length; i++){
            testLink.add("test array size " + i);
        }
        Object[] testArray = testLink.toArray();
        /*for(i = 0; i < array_length; i++){
            System.out.println(testArray[i]);
        }
        if(testArray.equals(testLink)){
            test_array = true;
        }
        else{
            test_array = false;
        }

        
        return test_array;
    }*/
}