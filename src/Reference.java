import java.util.HashMap;

// Class for keeping "global" values
class Reference {
    public static final HashMap<Integer, String> NUMBERS = new HashMap<Integer, String>();

    static {
        NUMBERS.put(1000, "M");
        NUMBERS.put(900, "CM");
        NUMBERS.put(500, "D");
        NUMBERS.put(400, "CD");
        NUMBERS.put(100, "C");
        NUMBERS.put(90, "XC");
        NUMBERS.put(50, "L");
        NUMBERS.put(40, "XL");
        NUMBERS.put(10, "X");
        NUMBERS.put(5, "V");
        NUMBERS.put(4, "IV");
        NUMBERS.put(1, "I");
    }
}