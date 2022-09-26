public class Main {

    static String FILENAME = "file.txt";
    static String FILEPATH = "files/"+FILENAME;
    
    public static void main(String[] args) {

        NumberTester numberTester = new NumberTester(FILEPATH);

        NumberTest isEven = (p) -> p%2==0;
        NumberTest isPrime = (p) -> {
            for (int i = 2; i <= p / 2; ++i) {
                if (p % i == 0) {
                    return true;
                }
            }
            return false;
        };
        NumberTest isPalindrome = (p) -> {

            int number =p;
            int reverse =0;

            while(number!=0){
                int remaining = number%10;
                reverse = reverse*10+remaining;
                number = number/10;
            }

            if(reverse == p){
                return true;
            }
            return false;
        };

        numberTester.setOddEvenTester(isEven);
        numberTester.setPrimeTester(isPrime);
        numberTester.setPalindromeTester(isPalindrome);
    }
}
