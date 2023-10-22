package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;

import static baseball.controller.GameController.answerNumber;

public class CountController {

    public int getStrikeCount(InputNumber inputNumber) {
        int strikeCount = 0;

        for (int i = 0; i < answerNumber.getRandomNumber().size(); i++) {
            int elementOfAnswer = answerNumber.getRandomNumber().get(i);
            int elementOfInput = inputNumber.getInputNumber().get(i);

            if (elementOfAnswer == elementOfInput) {
                strikeCount++;
            }
        }
        System.out.println("스트라이크: " + strikeCount);
        return strikeCount;
    }

    public int getBallCount(InputNumber inputNumber) {
        int ballCount = 0;

        for (int i = 0; i < answerNumber.getRandomNumber().size(); i++) {
            int elementOfAnswer = answerNumber.getRandomNumber().get(i);
            int elementOfInput = inputNumber.getInputNumber().get(i);

            if (elementOfAnswer != elementOfInput && answerNumber.getRandomNumber().contains(elementOfInput)) {
                ballCount++;
            }
        }
        System.out.println("볼: " + ballCount);
        return ballCount;
    }

}
