package baseball;

public class Utils {

    public static int parseIntWithTypeCheck(String rawInput) {
        int parsedInt;

        try {
            parsedInt = Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return parsedInt;
    }
}
