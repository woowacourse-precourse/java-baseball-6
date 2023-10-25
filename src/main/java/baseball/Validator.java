package baseball;

public class Validator {
    public static int validateInputData(String inputData) {
        try {
            return Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateUserNumber(int userNumber) {
        if (isUserNumberOutOfRange(userNumber) || isUserNumberOverlap(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    private static boolean isUserNumberOutOfRange(int userNumber) {
        return userNumber > 999 || userNumber < 100;
    }

    private static boolean isUserNumberOverlap(int userNumber) {
        int tripleDigit = userNumber / 100;
        int doubleDigit = (userNumber / 10) % 10;
        int singleDigit = userNumber % 10;
        return (tripleDigit == doubleDigit) || (doubleDigit == singleDigit) || (tripleDigit == singleDigit);
    }

    public static int validateGameStatusDecision(int gameStatusDecision) {
        if (isGameStatusDecisionMismatch(gameStatusDecision)) {
            throw new IllegalArgumentException();
        }
        return gameStatusDecision;
    }

    private static boolean isGameStatusDecisionMismatch(int gameStatusDecision) {
        return gameStatusDecision != 1 && gameStatusDecision != 2;
    }
}
