package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;

import java.util.List;

public class GameController {
    static final AnswerNumber answerNumber = new AnswerNumber();
    static InputNumber inputNumber = new InputNumber();

    public void createAnswer() {
        answerNumber.createRandomNumberList();
        System.out.println("정답: " + answerNumber.getRandomNumber());
    }

    public int getStrikeCount() {
        int strikeCount = 0;

        for (int i = 0; i < answerNumber.getRandomNumber().size(); i++) {
            int elementOfAnswer = answerNumber.getRandomNumber().get(i);
            int elementOfInput = inputNumber.getInputNumber().get(i);

            if (elementOfAnswer == elementOfInput) {
                strikeCount++;
            }
        }
        System.out.println("스트라이크 : " + strikeCount);
        return strikeCount;
    }

}

