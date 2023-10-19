package baseball;

public class Umpire {

    public static int countStrike(final int originNumber, final int testNumber) {
        int count = 0;
        String[] origin = convertStringToArray(convertNumberToString(originNumber));
        String[] test = convertStringToArray(convertNumberToString(testNumber));

        for (int i = 0; i < origin.length; i++) {
            if (isBothSame(origin[i], test[i])) {
                count++;
            }
        }

        return count;
    }

    private static String convertNumberToString(final int number) {
        return String.valueOf(number);
    }

    private static String[] convertStringToArray(final String input) {
        return input.split("");
    }

    private static boolean isBothSame(final String origin, final String test) {
        return origin.equals(test);
    }
}
