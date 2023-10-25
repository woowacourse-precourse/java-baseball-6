package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;

import java.util.List;

public class CountController {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public int getStrikeCount(InputNumber inputNumber, AnswerNumber answerNumber) {
        List<Integer> answer = answerNumber.getRandomNumber();
        List<Integer> input = inputNumber.getInputNumber();
        int strikeCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            int elementOfAnswer = answer.get(i);
            int elementOfInput = input.get(i);

            if (elementOfAnswer == elementOfInput) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCount(InputNumber inputNumber, AnswerNumber answerNumber) {
        List<Integer> answer = answerNumber.getRandomNumber();
        List<Integer> input = inputNumber.getInputNumber();
        int ballCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            int elementOfAnswer = answer.get(i);
            int elementOfInput = input.get(i);

            if (elementOfAnswer != elementOfInput && answer.contains(elementOfInput)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public String getHintMessage(InputNumber inputNumber, AnswerNumber answerNumber) {
        StringBuilder output = new StringBuilder();
        int ballCount = getBallCount(inputNumber, answerNumber);
        int strikeCount = getStrikeCount(inputNumber, answerNumber);

        if (ballCount != 0) {
            output.append(ballCount + BALL_MESSAGE);
        }

        if (strikeCount != 0) {
            output.append(strikeCount + STRIKE_MESSAGE);
        }

        if (output.isEmpty()) {
            output.append(NOTHING_MESSAGE);
        }
        return output.toString();
    }

    public boolean isSucceeded(InputNumber inputNumber, AnswerNumber answerNumber) {
        if (getStrikeCount(inputNumber, answerNumber) == NUMBER_OF_DIGITS) {
            return true;
        }
        return false;
    }

}
