import java.util.Objects;


class NumberConverter {

    public static int romanToArabic(String romanNumber) {
        Integer arabicNumber = 1;
        for (Integer number : Reference.NUMBERS.keySet()) {
            String value = Reference.NUMBERS.get(number);
            if (Objects.equals(romanNumber, value)) {
                arabicNumber = number;
                break;
            }
        }
        return arabicNumber;
    }

//    public static String arabicToRoman(int arabicNumber) {
//        int p = 0;
//        String romanNumber = "";
//        while (arabicNumber != 0) {
//            while (arabicNumber >= Reference.NUMBERS.get(p)) {
//
//            }
//            p++;
//        }
//        return romanNumber;
//    }

    public static void showNumbers() {
        for (Integer number : Reference.NUMBERS.keySet()) {
            String key = number.toString();
            String value = Reference.NUMBERS.get(number);
            System.out.println(key + " " + value);
        }
    }

    public static String convertToRoman(int number) {
        String romanNumber = "";


        return romanNumber;
    }

}
