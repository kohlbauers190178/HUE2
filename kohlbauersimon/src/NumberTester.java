import java.io.File;
import java.util.Scanner;

public class NumberTester {

    String fileName;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    String MSGISEVEN = "EVEN";
    String MSGISODD = "ODD";

    String MSGISPRIME = "PRIME";
    String MSGISNOPRIME = "NO PRIME";

    String MSGISPALINDROME = "PALINDROME";
    String MSGISNOPALINDROME = "NO PALINDROME";

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {

        try {
            Scanner reader = new Scanner(new File(fileName));
            String line = reader.nextLine();
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                String[] parts = line.split(" ");

                if (parts.length > 1) {
                    int numberToBeTested = Integer.parseInt(parts[1]);
                    switch (Integer.parseInt(parts[0])) {
                        case 1:
                            if (oddTester.testNumber(numberToBeTested)) {
                                System.out.println(MSGISEVEN);
                            } else {
                                System.out.println(MSGISODD);
                            }
                            break;
                        case 2:
                            if (primeTester.testNumber(numberToBeTested)) {
                                System.out.println(MSGISPRIME);
                            } else {
                                System.out.println(MSGISNOPRIME);
                            }
                            break;
                        case 3:
                            if (palindromeTester.testNumber(numberToBeTested)) {
                                System.out.println(MSGISPALINDROME);
                            } else {
                                System.out.println(MSGISNOPALINDROME);
                            }
                            break;
                        default:
                            System.out.println("ERROR at reading file " + fileName + "; line: " + line);

                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
