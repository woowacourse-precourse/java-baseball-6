package baseball;

public class IntegerConvertor {
    private IntegerConvertor() {
    }

    public static int toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_INTEGER);
        }
    }
}
