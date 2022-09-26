import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class NumberTester {

    String fileName;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

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
            Scanner reader = new Scanner(fileName);
            String line;
            reader.nextLine();
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                String[] parts = line.split(" ");

                if (parts.length > 1) {
                    switch (Integer.parseInt(parts[0])) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("ERROR at reading file "+fileName+"; line: "+line);

                    }
                }

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
