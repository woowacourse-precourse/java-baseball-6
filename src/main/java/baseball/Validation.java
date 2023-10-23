package baseball;

public class Validation {
    private static final int START_INCLUSIVE = Constants.START_INCLUSIVE;
    private static final int END_INCLUSIVE = Constants.END_INCLUSIVE;
    private static final int ANSWER_DIGIT = Constants.ANSWER_DIGIT;
    private static final String START = Constants.START;
    private static final String QUIT = Constants.QUIT;

    public void validateNumberInput(String input) {
        // 입력값이 3자리 숫자인지 확인
        if (input.length() != ANSWER_DIGIT) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);

            // 입력값이 숫자가 아닌 경우
            if (digit < (char) ('0' + START_INCLUSIVE) || digit > (char) ('0' + END_INCLUSIVE)) {
                throw new IllegalArgumentException();
            }

            // 입력값 중복 확인
            for (int j = 0; j < i; j++) {
                if (input.charAt(j) == digit) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void validateGameStatusInput(String gameStatusInput) {
        if (!gameStatusInput.equals(START) && !gameStatusInput.equals(QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
