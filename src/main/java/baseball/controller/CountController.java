package baseball.controller;

import baseball.model.InputNumber;

import static baseball.controller.GameController.ANSWER_NUMBER;

public class CountController {
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";


    public int getStrikeCount(InputNumber inputNumber) {
        int strikeCount = 0;

        for (int i = 0; i < ANSWER_NUMBER.getRandomNumber().size(); i++) {
            int elementOfAnswer = ANSWER_NUMBER.getRandomNumber().get(i);
            int elementOfInput = inputNumber.getInputNumber().get(i);

            if (elementOfAnswer == elementOfInput) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCount(InputNumber inputNumber) {
        int ballCount = 0;

        for (int i = 0; i < ANSWER_NUMBER.getRandomNumber().size(); i++) {
            int elementOfAnswer = ANSWER_NUMBER.getRandomNumber().get(i);
            int elementOfInput = inputNumber.getInputNumber().get(i);

            if (elementOfAnswer != elementOfInput && ANSWER_NUMBER.getRandomNumber().contains(elementOfInput)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public String getHintMessage(InputNumber inputNumber) {
        StringBuilder output = new StringBuilder();
        int ballCount = getBallCount(inputNumber);
        int strikeCount = getStrikeCount(inputNumber);

        if (ballCount != 0) {
            output.append(getBallCount(inputNumber) + BALL_MESSAGE);
        }

        if (strikeCount != 0) {
            output.append(getStrikeCount(inputNumber) + STRIKE_MESSAGE);
        }

        if (output.isEmpty()) {
            output.append(NOTHING_MESSAGE);
        }
        return output.toString();
    }

}
