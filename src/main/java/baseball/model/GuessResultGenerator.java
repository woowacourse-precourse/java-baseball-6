package baseball.model;

import java.util.List;

import static baseball.model.GameStatus.GUESS_RIGHT;
import static baseball.model.GameStatus.GUESS_WRONG;

public class GuessResultGenerator {

    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private boolean[] isMatched = new boolean[3];

    public GuessResultGenerator() {
    }

    public GuessResult generateResult(List<Integer> hiddenNumber, List<Integer> guessNumber) {
        int strikeCount = calculateStrikeCount(hiddenNumber, guessNumber);
        if (strikeCount == 3) {
            return new GuessResult(generateMessage(strikeCount, STRIKE), GUESS_RIGHT);
        }

        int ballCount = calculateBallCount(hiddenNumber, guessNumber);
        if (strikeCount == 0 && ballCount == 0) {
            return new GuessResult(NOTHING, GUESS_WRONG);
        }
        String ballResult = generateMessage(ballCount, BALL);
        String strikeResult = generateMessage(strikeCount, STRIKE);
        if (!ballResult.isEmpty()) {
            return new GuessResult((ballResult + " " + strikeResult).trim(), GUESS_WRONG);
        }

        return new GuessResult(strikeResult, GUESS_WRONG);
    }

    public void resetIsMatched() {
        for (int i = 0; i < 3; i++) {
            isMatched[i] = false;
        }
    }

    private int calculateStrikeCount(List<Integer> hiddenNumber, List<Integer> guessNumber) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (hiddenNumber.get(i).equals(guessNumber.get(i))) {
                strikeCount++;
                isMatched[i] = true;
            }
        }
        return strikeCount;
    }

    private int calculateBallCount(List<Integer> hiddenNumber, List<Integer> guessNumber) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (!isMatched[i] && hiddenNumber.contains(guessNumber.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private String generateMessage(int count, String typeOfCount) {
        if (count == 0) {
            return "";
        }
        return Integer.toString(count) + typeOfCount;
    }
}
