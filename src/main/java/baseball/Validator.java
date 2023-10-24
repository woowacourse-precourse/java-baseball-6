package baseball;

public class Validator {
    public static int validateInputData(String inputData) {
        try {
            return Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateNumberSuggestion(int numberSuggestion) {
        if (isNumberSuggestionOutOfRange(numberSuggestion) || isNumberSuggestionOverlap(numberSuggestion)) {
            throw new IllegalArgumentException();
        }
        return numberSuggestion;
    }

    public static boolean isNumberSuggestionOutOfRange(int numberSuggestion) {
        return numberSuggestion > 999 || numberSuggestion < 100;
    }

    public static boolean isNumberSuggestionOverlap(int numberSuggestion) {
        int tripleDigit = numberSuggestion / 100;
        int doubleDigit = (numberSuggestion / 10) % 10;
        int singleDigit = numberSuggestion % 10;
        return (tripleDigit == doubleDigit) || (doubleDigit == singleDigit) || (tripleDigit == singleDigit);
    }

    public static int validateRetryOrEnd(int retryOrEnd) {
        if (isRetryOrEndMismatch(retryOrEnd)) {
            throw new IllegalArgumentException();
        }
        return retryOrEnd;
    }

    public static boolean isRetryOrEndMismatch(int retryOrEnd) {
        return retryOrEnd != 1 && retryOrEnd != 2;
    }
}
