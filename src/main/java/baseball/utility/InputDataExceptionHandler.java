package baseball.utility;

public class InputDataExceptionHandler {
    public static void validateNumbers(String inputNumbers) {
        int numbersLength = inputNumbers.length();

        if(numbersLength != 3) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < numbersLength; i++) {
            char number = inputNumbers.charAt(i);
            if(number < '1' || number > '9') {
                throw new IllegalArgumentException();
            }
            for(int j = 0; j < i; j++) {
                if(number == inputNumbers.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static void validateReGame(String continued) {
        if (!(continued.equals("1") || continued.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
