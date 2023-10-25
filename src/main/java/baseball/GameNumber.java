package baseball;

public class GameNumber {
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
        return hasThreeDigits(input) && hasProperRange(input) && hasDistinctDigits(input);
    }

    private static boolean hasThreeDigits(String input) {
        return input.length() == 3;
    }

    private static boolean hasProperRange(String input) {
        return input.chars().allMatch(digit -> digit >= '1' && digit <= '9');
    }

    private static boolean hasDistinctDigits(String input) {
        return input.chars().distinct().count() == 3;
    }

    public GameResult judge(GameNumber guessed) {
        int strike = 0;
        int ball = 0;
        boolean isCorrectAnswer;

        // TODO: for문 리팩토링 구조 고민해보기
        for (int idx = 0; idx < 3; idx++) {
            if (isStrike(guessed, idx)) {
                strike++;
            } else if (isBall(guessed, idx)) {
                ball++;
            }
        }

        isCorrectAnswer = (strike == 3);

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
