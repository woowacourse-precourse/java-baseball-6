package baseball.validation;

public class Validator {
    public static boolean isSize(final String target, final int size) {
        return target.length() == size;
    }

    public static boolean isDigit(final String target) {
        for (char c : target.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBetweenNumber(final String target, final int min, final int max) {
        for (char c : target.toCharArray()) {
            int number = Character.getNumericValue(c);
            if ((number < min) && (number > max)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicateNumber(final String target, final int size) {
        String[] targetArray = target.split("");
        long count = Arrays.stream(targetArray)
                .distinct()
                .count();
        return count == size;
    }
}
