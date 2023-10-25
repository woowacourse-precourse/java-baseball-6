package baseball.logic;

import baseball.output.Message;

import java.util.List;

public class CompareLogic {
    public static final int RANDOM_NUMBER_MAX_LENGTH = 3;
    public static final int ANSWER_STRIKE_COUNT = 3;

    public static final String BALL_MESSAGE = "볼 ";
    public static final String STRIKE_MESSAGE = "스트라이크 ";
    public static final String NOTHING_MESSAGE = "낫싱";

    List<Integer> answerNumbers, userNumbers;

    public CompareLogic(List<Integer> answerNumbers, List<Integer> userNumbers) {
        this.answerNumbers = answerNumbers;
        this.userNumbers = userNumbers;
    }

    public boolean isAnswer() {
        int ballCount = countNumberOfBall();
        int strikeCount = countNumberOfStrike();
        if (strikeCount == ANSWER_STRIKE_COUNT) {
            Message.printEndMessage();
            return true;
        }

        String OUTPUT_MESSAGE = "";
        if (ballCount > 0) {
            OUTPUT_MESSAGE += (ballCount + BALL_MESSAGE);
        }
        if (strikeCount > 0) {
            OUTPUT_MESSAGE += (strikeCount + STRIKE_MESSAGE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            OUTPUT_MESSAGE += NOTHING_MESSAGE;
        }

        System.out.println(OUTPUT_MESSAGE);
        return false;
    }

    public int countNumberOfBall() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            int answerNumber = answerNumbers.get(i);
            int numberIndex = userNumbers.indexOf(answerNumber);

            if (i != numberIndex && numberIndex != -1) {
                count++;
            }
        }
        return count;
    }

    public int countNumberOfStrike() {
        int count = 0;
        for (int i = 0; i < RANDOM_NUMBER_MAX_LENGTH; i++) {
            int answerNumber = answerNumbers.get(i);
            int numberIndex = userNumbers.indexOf(answerNumber);

            if (i == numberIndex) {
                count++;
            }
        }
        return count;
    }
}
