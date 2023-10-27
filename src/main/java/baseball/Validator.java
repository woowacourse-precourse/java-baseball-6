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
        int firstDigit = userNumber / 100;
        int secondDigit = (userNumber / 10) % 10;
        int thirdDigit = userNumber % 10;
        return (firstDigit == secondDigit) || (secondDigit == thirdDigit) || (firstDigit == thirdDigit);
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