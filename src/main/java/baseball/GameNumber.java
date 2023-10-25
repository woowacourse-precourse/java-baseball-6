package baseball;

public class GameNumber {
    private final String value;

    public String getValue() {
        return value;
    }

    private GameNumber(String value) {
        this.value = value;
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
        for (int i = 0; i < 3; i++) {
            if (this.value.charAt(i) == guessed.value.charAt(i)) {
                strike++;
            } else if (this.value.contains(String.valueOf(guessed.value.charAt(i)))) {
                ball++;
            }
        }

        isCorrectAnswer = (strike == 3);

        return new GameResult(strike, ball, isCorrectAnswer);
    }
}
