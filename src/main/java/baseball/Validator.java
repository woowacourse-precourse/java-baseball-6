package baseball;

public class Validator {

        public static int validateInputData(String inputData) {
                try {
                        return Integer.parseInt(inputData);
                } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                }
        }

        public static void validateNumberSuggestion(int numberSuggestion) {
                if (checkNumberSuggestionRange(numberSuggestion) || checkNumberSuggestionOverlap(numberSuggestion)){
                        throw new IllegalArgumentException();
                }
        }

        public static boolean checkNumberSuggestionRange(int numberSuggestion) {
                return numberSuggestion > 999 || numberSuggestion < 100;
        }

        public static boolean checkNumberSuggestionOverlap(int numberSuggestion) {
                int tripleDigit = numberSuggestion / 100;
                int doubleDigit = (numberSuggestion / 10) % 10;
                int singleDigit = numberSuggestion % 10;
                return (tripleDigit == doubleDigit) || (doubleDigit == singleDigit) || (tripleDigit == singleDigit);
        }

        public static void validateRetryOrEnd(int retryOrEnd) {
                if (isRetryOrEnd(retryOrEnd)) {
                        throw new IllegalArgumentException();
                }
        }

        public static boolean isRetryOrEnd(int retryOrEnd) {
                return retryOrEnd != 1 && retryOrEnd != 2;
        }
}
