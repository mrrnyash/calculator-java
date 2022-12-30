import java.util.HashMap;

// Class for keeping "global" values
class Reference {
    public static final HashMap<Integer, String> NUMBERS = new HashMap<Integer, String>();
    public static final String[] ROMAN_NUMBERS = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    static {
        for (int i = 10; i > 0; i--) {
            NUMBERS.put(i, ROMAN_NUMBERS[i - 1]);
        }
    }
}