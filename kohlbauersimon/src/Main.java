import java.util.Scanner;

public class Main {

    static String FILENAME = "file.txt";
    static String FILEPATH = "files/" + FILENAME;

    public static void main(String[] args) {

        Main main = new Main();

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
            main.printMainUI();
            Scanner con = new Scanner(System.in);
            try {
                input = con.nextInt();

                switch (input) {
                    case 1:
                        main.rationalCalculator();
                        break;
                    case 2:
                        main.vectorCalculator();
                        break;
                    case 4:
                        System.out.println("ENDING PROGRAM");

                        break;
                    default:
                        main.noSuchOptionMessage(Integer.toString(input));
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
            tempB.setA(numeratorB);
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
            tempB.setA(numeratorB);
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

        Scanner con = new Scanner(System.in);

        Number numberA = new Number();

        Number numberB = new Number();

        try {
            System.out.println("Enter number x a:");
            numberA.setA(con.nextDouble());
            System.out.println("Enter number x b:");
            numberA.setB(con.nextDouble());

            System.out.println("Enter number y a:");
            numberB.setA(con.nextDouble());
            System.out.println("Enter number y b:");
            numberB.setB(con.nextDouble());

            if (numberA.getB() == 0 || numberB.getB() == 0) {
                denominatorZeroMessage(numberA, numberB);
                return;
            }

        } catch (Exception e) {
            System.out.println("ERROR at entering numbers");
            return;
        }

        printCalculatorUI();

        int input = 0;

        try {
            input = con.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR at choosing operation");
            return;
        }

        Number result = null;
        switch (input) {
            case 1 -> result = rationalCalculator.add(numberA, numberB);
            case 2 -> result = rationalCalculator.subtract(numberA, numberB);
            case 3 -> result = rationalCalculator.multiply(numberA, numberB);
            case 4 -> result = rationalCalculator.divide(numberA, numberB);
            case 5 -> rationalCalculator();
            default -> noSuchOptionMessage(Integer.toString(input));
        }

        if (result != null) {
            printResult(result);
        } else {
            System.out.println("no result");
        }
    }

    public void vectorCalculator() {

        CalculationOperation add = (a, b) -> {
            Number returnValue = new Number();
            returnValue.setA(a.getA() + b.getA());
            returnValue.setB(a.getB() + b.getB());
            return returnValue;
        };

        CalculationOperation subtract = (a, b) -> {
            Number returnValue = new Number();
            returnValue.setA(a.getA() - b.getA());
            returnValue.setB(a.getB() - b.getB());
            return returnValue;
        };

        CalculationOperation multiply = (a, b) -> {
            Number returnValue = new Number();
            returnValue.setA(a.getA() * b.getA());
            returnValue.setB(a.getB() * b.getB());
            return returnValue;
        };

        CalculationOperation divide = (a, b) -> null; //Internet sagt zwei Vektoren nicht so gut beim Dividieren

        //Quelle: Google
        //We cannot divide two vectors. The definition of a Vector space allows us to add two vectors, subtract two vectors, and multiply a vector by a scalar.

        VectorCalculator vectorCalculator = new VectorCalculator(add, subtract, multiply, divide);
        Scanner con = new Scanner(System.in);
        Number numberA = new Number();
        Number numberB = new Number();

        try {
            System.out.println("Enter number x a:");
            numberA.setA(con.nextDouble());
            System.out.println("Enter number x b:");
            numberA.setB(con.nextDouble());

            System.out.println("Enter number y a:");
            numberB.setA(con.nextDouble());
            System.out.println("Enter number y b:");
            numberB.setB(con.nextDouble());
        } catch (Exception e) {
            System.out.println("ERROR at entering numbers");
            return;
        }
        printCalculatorUI();
        int input = 0;
        try {
            input = con.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR at choosing operation");
            return;
        }

        Number result = null;
        switch (input) {
            case 1 -> result = vectorCalculator.add(numberA, numberB);
            case 2 -> result = vectorCalculator.subtract(numberA, numberB);
            case 3 -> result = vectorCalculator.multiply(numberA, numberB);
            case 4 -> result = vectorCalculator.divide(numberA, numberB);
            case 5 -> vectorCalculator();
            default -> noSuchOptionMessage(Integer.toString(input));
        }

        if (result != null) {
            printResult(result);
        } else {
            System.out.println("no result");
        }
    }


    public void printResult(Number result) {
        System.out.println("-----------------------");
        System.out.println("Result:");
        System.out.println(result.getA() + "/" + result.getB());
        System.out.println("-----------------------");
    }

    public void printCalculatorUI() {
        System.out.println("""
                Choose operation:
                1 = add
                2 = subtract
                3 = multiply
                4 = divide 
                5 = enter numbers again
                """);
    }

    public void printMainUI() {
        System.out.println("""
                Choose calculator:
                1 = Rational calculator
                2 = Vector calculator
                4 = Exit program""");
    }

    public void noSuchOptionMessage(String input) {
        System.out.println("There is no option for input \"" + input + "\"");
    }

    public void denominatorZeroMessage(Number a, Number b) {
        System.out.println("Denominator cannot be zero: \""+a.getA()+"/"+a.getB()+"\" \""+ b.getA()+"/"+b.getB()  + "\"");
    }
}
