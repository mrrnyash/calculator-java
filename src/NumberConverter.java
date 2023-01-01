import java.util.HashMap;


class NumberConverter {

    // Useful constants for number conversion
    private static final String romanAlphabet = "IVXLCDM";
    private static final Integer[] arabicNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static final HashMap<Integer, String> arToRom = new HashMap<Integer, String>();

    static {
        arToRom.put(1000, "M");
        arToRom.put(900, "CM");
        arToRom.put(500, "D");
        arToRom.put(400, "CD");
        arToRom.put(100, "C");
        arToRom.put(90, "XC");
        arToRom.put(50, "L");
        arToRom.put(40, "XL");
        arToRom.put(10, "X");
        arToRom.put(9, "IX");
        arToRom.put(5, "V");
        arToRom.put(4, "IV");
        arToRom.put(1, "I");
    }

    private static final HashMap<String, Integer> romToAr = new HashMap<String, Integer>();

    static {
        romToAr.put("M", 1000);
        romToAr.put("CM", 900);
        romToAr.put("D", 500);
        romToAr.put("CD", 400);
        romToAr.put("C", 100);
        romToAr.put("XC", 90);
        romToAr.put("L", 50);
        romToAr.put("XL", 40);
        romToAr.put("X", 10);
        romToAr.put("IX", 9);
        romToAr.put("V", 5);
        romToAr.put("IV", 4);
        romToAr.put("I", 1);
    }

    // Comparison of two Roman characters
    private static boolean romanCompare(char A, char B) {
        return romanAlphabet.indexOf(A) < romanAlphabet.indexOf(B);
    }


    // Conversion Roman to Arabic
    public static Integer romanToArabic(String rNumber) {
        int result = 0;
        // XXX -> 30
        for (int i = 0; i < rNumber.length(); i++) {
            char current = rNumber.charAt(i);
            if (romanAlphabet.indexOf(current) == -1) // if current character is wrong
                return null;
            if (i < rNumber.length() - 1 && romanCompare(current, rNumber.charAt(i + 1)))
                continue;
            if (i > 0 && romanCompare(rNumber.charAt(i - 1), current))
                result += romToAr.get(String.valueOf(current)) - romToAr.get(String.valueOf(rNumber.charAt(i - 1)));
            else
                result += romToAr.get(String.valueOf(current));
        }
        return result;
    }

    // Conversion Arabic to Roman
    public static String arabicToRoman(String aNumber) {
        int result = 0, p = 1;
        String rNumber = "";
        for (int i = aNumber.length() - 1; i >= 0; i--) {
            char current = aNumber.charAt(i);
            if (current >= '0' && current <= '9') {
                result += (current - '0') * p;
                p *= 10;
            } else {
                return null;
            }
        }
        int pos = 0;
        while (result != 0) {
            while (result >= arabicNumbers[pos]) {
                rNumber += romanNumbers[pos];
                result -= arabicNumbers[pos];
            }
            pos++;
        }
        return rNumber;
    }

    // Check if provided string is a correct Arabic number
    public static boolean isArabic(String aNumber) {
        for (int i = 0; i < aNumber.length(); i++)
            if (aNumber.charAt(i) < '0' || aNumber.charAt(i) > '9')
                return false;
        return true;
    }

    // Check if provided string is a correct Roman number
    public static boolean isRoman(String rNumber) throws Exception {
        for (int i = 0; i < rNumber.length(); i++) {
            if (romanAlphabet.indexOf(rNumber.charAt(i)) == -1) {
                return false;
            }
            if (i > 0) {
                char c1 = rNumber.charAt(i);
                char c2 = rNumber.charAt(i - 1);
                String current = "" + c2 + c1;
                if (romanCompare(c2, c1)) {
                    boolean ok = false;
                    for (int j = 0; j < romanNumbers.length; j++) {
                        if (romanNumbers[j].equals(current))
                            ok = true;
                    }
                    if (!ok) {
                        throw new Exception("Wrong format in Roman number " + rNumber);
                    }
                }
            }
        }

        return true;
    }

}