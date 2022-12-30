import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter an expression: ");
        String input = sc.nextLine();
    }

    private String calc(String input) throws Exception {
        if (!Reference.NUMBERS.containsValue(input)) {
            throw new Exception("Roman number must be from I (1) to X (10)");
        } else {
            String result = "";

            return result;
        }
    }

    private String calc(int input) {
        String result = "";

        return result;
    }

    private boolean checkInputString(String input) {
        boolean correct = false;

        return correct;

    }


}