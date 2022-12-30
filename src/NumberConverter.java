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

    public static void showNumbers() {
        for (Integer number : Reference.NUMBERS.keySet()) {
            String key = number.toString();
            String value = Reference.NUMBERS.get(number);
            System.out.println(key + " " + value);
        }

    }

}
