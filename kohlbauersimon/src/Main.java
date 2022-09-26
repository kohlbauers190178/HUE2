import java.util.Scanner;

public class Main {

    static String FILENAME = "file.txt";
    static String FILEPATH = "files/" + FILENAME;

    public static void main(String[] args) {

        System.out.println("-----------------------");
        System.out.println("Beispiel 3");
        System.out.println("-----------------------");

        NumberTester numberTester = new NumberTester(FILEPATH);

        NumberTest isEven = (p) -> p % 2 == 0;
        NumberTest isPrime = (p) -> {
            for (int i = 2; i <= p / 2; ++i) {
                if (p % i == 0) {
                    return false;
                }
            }
            return true;
        };
        NumberTest isPalindrome = (p) -> {

            int number = p;
            int reverse = 0;

            while (number != 0) {
                int remaining = number % 10;
                reverse = reverse * 10 + remaining;
                number = number / 10;
            }

            return reverse == p;
        };

        numberTester.setOddEvenTester(isEven);
        numberTester.setPrimeTester(isPrime);
        numberTester.setPalindromeTester(isPalindrome);

        numberTester.testFile();

        System.out.println("-----------------------");
        System.out.println("Beispiel 4");
        System.out.println("-----------------------");

        int input = 0;

        while (input != 4) {
            printMainUI();
            Scanner con = new Scanner(System.in);
            try {
                input = con.nextInt();

                switch (input) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 4:
                        System.out.println("ENDING PROGRAM");

                        break;
                    default:
                        System.out.println("There is no option for \"" + input + "\"");
                }

            } catch (Exception e) {
                System.out.println("Error at input");
            }
        }


    }

    public void rationalCalculator() {

        CalculationOperation add = (a, b) -> {
            double commonMultiple = a.getB() * b.getB();

            double numeratorA = a.getA() * b.getB();
            double numeratorB = b.getA() * a.getB();

            Number tempA = new Number();
            tempA.setA(numeratorA);
            tempA.setB(commonMultiple);

            Number tempB = new Number();
            tempB.setB(numeratorB);
            tempB.setB(commonMultiple);

            Number returnValue = new Number();
            returnValue.setA(tempA.getA() + tempB.getA());
            returnValue.setB(commonMultiple);

            double gcd = RationalCalculator.gcd(returnValue.getA(), returnValue.getB());

            returnValue.setA(returnValue.getA() / gcd);
            returnValue.setB(returnValue.getB() / gcd);

            return returnValue;
        };

        CalculationOperation subtract = (a, b) -> {
            double commonMultiple = a.getB() * b.getB();

            double numeratorA = a.getA() * b.getB();
            double numeratorB = b.getA() * a.getB();

            Number tempA = new Number();
            tempA.setA(numeratorA);
            tempA.setB(commonMultiple);

            Number tempB = new Number();
            tempB.setB(numeratorB);
            tempB.setB(commonMultiple);

            Number returnValue = new Number();
            returnValue.setA(tempA.getA() - tempB.getA());
            returnValue.setB(commonMultiple);

            double gcd = RationalCalculator.gcd(returnValue.getA(), returnValue.getB());

            returnValue.setA(returnValue.getA() / gcd);
            returnValue.setB(returnValue.getB() / gcd);

            return returnValue;
        };

        CalculationOperation multiply = (a, b) -> {
            Number returnValue = new Number();
            returnValue.setA(a.getA() * b.getA());
            returnValue.setB(a.getB() * b.getB());

            double gcd = RationalCalculator.gcd(returnValue.getA(), returnValue.getB());
            returnValue.setA(returnValue.getA() / gcd);
            returnValue.setB(returnValue.getB() / gcd);

            return returnValue;
        };

        CalculationOperation divide = (a, b) -> {
            Number reciprocalofB = new Number();
            reciprocalofB.setA(b.getB());
            reciprocalofB.setB(b.getA());

            Number returnValue = new Number();
            returnValue.setA(a.getA() * reciprocalofB.getA());
            returnValue.setB(a.getB() * reciprocalofB.getB());

            double gcd = RationalCalculator.gcd(returnValue.getA(), returnValue.getB());
            returnValue.setA(returnValue.getA() / gcd);
            returnValue.setB(returnValue.getB() / gcd);

            return returnValue;
        };

        RationalCalculator rationalCalculator = new RationalCalculator(add, subtract, multiply, divide);

        int input = 0;
        Scanner con = new Scanner(System.in);

        try {
            Number numberA = new Number();
            System.out.println("Enter number x a:");
            numberA.setA(con.nextDouble());
            System.out.println("Enter number x b:");
            numberA.setB(con.nextDouble());

            Number numberB = new Number();
            System.out.println("Enter number y a:");
            numberB.setA(con.nextDouble());
            System.out.println("Enter number y b:");
            numberB.setB(con.nextDouble());


        } catch (Exception e) {
            System.out.println("ERROR at entering numbers");
            return;
        }

        

    }

    public static void printRationalCalculatorUI() {
        System.out.println("""
                Choose operation:
                1 = add
                2 = subtract
                3 = multiply
                4 = divide 
                5 = enter numbers again
                """);
    }

    public static void printMainUI() {
        System.out.println("""
                Choose calculator:
                1 = Rational calculator
                2 = Vector calculator
                4 = Exit program""");
    }
}
