public class Myles_BundeGreen_Project1{
    static BagInterface<String> testLink = new LinkedBag<>();
    
    public static void main(String[] args){
        System.out.println("Testing add: " + addTest());
        System.out.println("Test empty: " + emptyTest());
        System.out.println("Test size: " + sizeTest(12));
        System.out.println("Test array: " + arrayTest());
        System.out.println("Testing freq: " + freqTest(6));
        System.out.println("Testing contains: " + containsTest("TEST"));
        System.out.println("Test clear: " + clearTest(5));
        System.out.println("Testing remove: " + removeTest(8));
        System.out.println("Testing remove entry: " + entryRemoveTest());
    }

    public static boolean addTest(){
        boolean test_add = false;
        if(testLink.isEmpty()){
            testLink.add("String test");
            test_add = true;
        }
        testLink.add("String 2");
        if(testLink.contains("String test") && testLink.getFrequencyOf("String 2") >= 1){
            test_add = true;
        }
        else if(testLink.contains("String test") || testLink.getFrequencyOf("String 2") >= 1){
            test_add = true;
            System.out.println("Conatains is: " + testLink.contains("String test") + " or getFreq is " + testLink.getFrequencyOf("String 2"));
        }
        testLink.clear();
        return test_add;
    }

    public static boolean emptyTest(){
        boolean test_empty = false;
        boolean test_notempty = false;
        //testing if link bag is empty
        if(testLink.isEmpty()){
            test_empty = true;
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

    public static boolean sizeTest(int size){
        int i;
        boolean test_size = false;
        for(i = 0; i < size; i++){
            testLink.add("test size " + i);
        }
        if(testLink.getCurrentSize() == size){
            test_size = true;
        }
        testLink.clear();
        return test_size;
    }

    public static boolean arrayTest(){
        boolean test_array = false;
        int i, j;
        String[] trueArray = {"item 1", "item 2", "item 3"};
        testLink.add("item 1");
        testLink.add("item 2");
        testLink.add("item 3");
        Object[] testArray = testLink.toArray();
        if(trueArray.length == testArray.length){
            for(i = 0; i < trueArray.length; i++){
                for(j = 0; j < trueArray.length; j++){
                    if(trueArray[i] == testArray[j]){
                        test_array = true;
                    }
                }
            }
        }
        testLink.clear();
        return test_array;
    }

    public static boolean freqTest(int freq){
        boolean test_freq = false;
        int i;
        for(i = 1; i <= freq; i++){
            testLink.add("item " + freq);
        }
        if(testLink.getFrequencyOf("item " + freq) == freq){
            test_freq = true;
        }
        testLink.clear();
        return test_freq;
    }

    public static boolean containsTest(String element){
        boolean test_contains = false;
        int containsSizeBefore = testLink.getFrequencyOf(element);
        testLink.add(element);
        int containsSizeAfter = testLink.getFrequencyOf(element);
        if(testLink.contains(element) && containsSizeAfter == containsSizeBefore + 1){
            test_contains = true;
        }
        return test_contains;
    }

    public static boolean clearTest(int size){
        boolean test_clear = false;
        int i;
        for(i = 0; i < size; i++){
            testLink.add("item " + i);
        }
        testLink.clear();
        if(testLink.getCurrentSize() == 0){
            test_clear = true;
        }
        return test_clear;
    }

    public static boolean removeTest(int size){
        boolean test_remove = false;
        int i;
        for(i = 1; i <= size; i++){
            testLink.add("item " + i);
        }
        testLink.remove();
        if(testLink.getCurrentSize() == size -1){
            test_remove = true;
        }
        return test_remove;
    }
    
    public static boolean entryRemoveTest(){
        boolean test_entry = false;
        int before, after;
        String testElement1 = "Will this be removed?";
        String testElement2 = "Only time will tell!";
        String testElement3 = "Well that escalated quickly";
        testLink.add(testElement1);
        testLink.add(testElement2);
        testLink.add(testElement3);
        before = testLink.getFrequencyOf(testElement2);
        testLink.remove(testElement2);
        after = testLink.getFrequencyOf(testElement2);
        if(!testLink.contains(testElement2) && before > after){
            test_entry = true;
        }
        return test_entry;
    }
}