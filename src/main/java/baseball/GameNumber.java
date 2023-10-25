package baseball;

public class GameNumber {
    public static final int NUMBER_LENGTH = 3;
    private final String value;

    private GameNumber(String value) {
        this.value = value;
    }

    public char getCharAt(int index) {
        return value.charAt(index);
    }

    public static GameNumber from(String input) {
        validate(input);
        return new GameNumber(input);
    }

    private static void validate(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValid(String input) {
        return hasProperLength(input) && hasProperRange(input) && hasDistinctDigits(input);
    }

    private static boolean hasProperLength(String input) {
        return input.length() == NUMBER_LENGTH;
    }

    private static boolean hasProperRange(String input) {
        return input.chars().allMatch(digit -> digit >= '1' && digit <= '9');
    }

    private static boolean hasDistinctDigits(String input) {
        return input.chars().distinct().count() == NUMBER_LENGTH;
    }

    public GameResult judge(GameNumber guessed) {
        int strike = 0;
        int ball = 0;
        boolean isCorrectAnswer;

        for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
            if (isStrike(guessed, idx)) {
                strike++;
            } else if (isBall(guessed, idx)) {
                ball++;
            }
        }

        isCorrectAnswer = (strike == NUMBER_LENGTH);

        return new GameResult(strike, ball, isCorrectAnswer);
    }

    private boolean isStrike(GameNumber guessed, int index) {
        return this.getCharAt(index) == guessed.getCharAt(index);
    }

    private boolean isBall(GameNumber guessed, int index) {
        String keyword = String.valueOf(guessed.getCharAt(index));
        return this.value.contains(keyword);
    }
}
