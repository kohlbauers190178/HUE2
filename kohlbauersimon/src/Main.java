public class Main {

    static String FILENAME = "file.txt";
    static String FILEPATH = "files/"+FILENAME;
    
    public static void main(String[] args) {

        NumberTester numberTester = new NumberTester(FILEPATH);

        NumberTest isEven = (p) -> p%2==0;

        //TODO: ausprogrammian
        NumberTest isPrime = (p) -> true;
        NumberTest isPalindrome = (p) -> true;

        numberTester.setOddEvenTester(isEven);
        numberTester.setPrimeTester(isPrime);
        numberTester.setPalindromeTester(isPalindrome);
    }
}
