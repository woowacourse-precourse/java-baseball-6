package baseball.controller;

import baseball.model.AnswerNumber;

import static baseball.controller.GameController.answerNumber;
import static baseball.controller.GameController.inputNumber;

public class CountController {

    public int getStrikeCount() {
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

    public int getBallCount() {
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
