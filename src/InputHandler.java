public class InputHandler {

    public static boolean checkInputString(String input) throws Exception {
        String[] inputArray = input.split("\\s+");
        // Check if input has 3 elements
        if (inputArray.length != 3) {
            throw new Exception("Expression must contain two operands and one operator");
        }


        return true;
    }



}
