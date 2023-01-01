import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // Read string input from user
        String result = calc(input);
        System.out.println(result);

        // Number conversion test
//        Integer res = NumberConverter.romanToArabic("XLIV");
//        if(res != null)
//            System.out.println(res);
//        else
//            System.out.println("Error. Function return null!");
//
//        String res = NumberConverter.arabicToRoman("19");
//        if(res != null)
//            System.out.println(res);
//        else
//            System.out.println("Function return null");


        // 800 tests
//        String ops = "+-*/";
//        System.out.println("arabic numbers");
//        for (int i = 1; i <= 10; i++) {
//            for (int j = 1; j <= 10; j++) {
//                for (int k = 0; k < 4; k++) {
//                    String testInput = String.valueOf(i) + " " + ops.charAt(k) + " " + String.valueOf(j);
//                    System.out.println(testInput + " = " + calc(testInput));
//                }
//            }
//        }
//        System.out.println("roman numbers");
//        for (int i = 1; i <= 10; i++) {
//            for (int j = 1; j <= 10; j++) {
//                for (int k = 0; k < 4; k++) {
//                    String testInput = NumberConverter.arabicToRoman(String.valueOf(i)) + " " + ops.charAt(k) + " " + NumberConverter.arabicToRoman(String.valueOf(j));
//                    System.out.println(testInput + " = " + calc(testInput));
//                }
//            }
//        }
    }

    // Calculations
    private static String calc(String input) throws Exception {
        String firstNumber, secondNumber;
        boolean bOper = false;
        int posOper = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                if (bOper) {
                    throw new Exception("Expression must contain only one operator. Found more.");
                } else {
                    bOper = true;
                    posOper = i;
                }
            }
        }

        // Split expression on operator as delimiter
        int pos = posOper - 1;
        while (pos > 0 && input.charAt(pos) == ' ')
            pos--;
        firstNumber = input.substring(0, pos + 1);
        pos = posOper + 1;
        while (pos < input.length() - 1 && input.charAt(pos) == ' ')
            pos++;
        secondNumber = input.substring(pos);

        boolean romanOutput = false;
        Integer aFirstNumber = 0, aSecondNumber = 0;

        if (NumberConverter.isArabic(firstNumber) && NumberConverter.isArabic(secondNumber)) {
            aFirstNumber = Integer.parseInt(firstNumber);
            aSecondNumber = Integer.parseInt(secondNumber);
        } else {
            if (NumberConverter.isRoman(firstNumber) && NumberConverter.isRoman(secondNumber)) {
                aFirstNumber = NumberConverter.romanToArabic(firstNumber);
                aSecondNumber = NumberConverter.romanToArabic(secondNumber);
                romanOutput = true;
            } else {
                throw new Exception("Both operands must be in the same number system!");
            }
        }

        Integer result = 0;
        char operator = input.charAt(posOper);
        switch (operator) {
            case '+':
                result = aFirstNumber + aSecondNumber;
                break;
            case '-':
                result = aFirstNumber - aSecondNumber;
                break;
            case '*':
                result = aFirstNumber * aSecondNumber;
                break;
            case '/':
                result = aFirstNumber / aSecondNumber;
                break;
        }

        if (romanOutput) {
            if (result <= 0) {
                throw new Exception("Wrong result in the Roman number system!");
                // return "Wrong Answer!"; // Used for test
            } else
                return NumberConverter.arabicToRoman(String.valueOf(result));
        } else {
            return String.valueOf(result);
        }
    }

}