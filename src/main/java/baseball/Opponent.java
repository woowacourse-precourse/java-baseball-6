package baseball;

public class Opponent {
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MINIMUM_NUMBER = 1;

    private final int numberLength;
    private final boolean[] isTargetNumber;
    private final String target;

    public Opponent(int numberLength) {
        this.numberLength = numberLength;
        this.isTargetNumber = new boolean[numberLength];
        this.target = generateTarget();
    }

    public GuessResult guess(String guess) {
        validate(guess);

        int strike = 3;
        int ball = 0;

        return new GuessResult(ball, strike);
    }

    private String generateTarget() {
        return "123";
    }

    private void validate(String guess) {
        long uniqueNumberCount = guess.chars()
                .distinct()
                .count();

        boolean isValid = uniqueNumberCount == numberLength;

        isValid &= guess.chars()
                .map(character -> character - '0')
                .allMatch(this::isNumberInRange);

        if (!isValid) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumberInRange(int number) {
        return MINIMUM_NUMBER <= number && number <= MAXIMUM_NUMBER;
    }
}
