package baseball.controller;

import baseball.model.InputNumber;

import static baseball.controller.GameController.ANSWER_NUMBER;

public class CountController {

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
            output.append(getBallCount(inputNumber) + "볼 ");
        }

        if (strikeCount != 0) {
            output.append(getStrikeCount(inputNumber) + "스트라이크");
        }

        if (output.isEmpty()) {
            output.append("낫싱");
        }
        return output.toString();
    }

}
