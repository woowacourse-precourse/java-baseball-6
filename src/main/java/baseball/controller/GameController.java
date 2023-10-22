package baseball.controller;

import baseball.model.AnswerNumber;

public class GameController {
    static final AnswerNumber answerNumber = new AnswerNumber();

    public void createAnswer() {
        answerNumber.createRandomNumberList();
        System.out.println("정답: " + answerNumber.getRandomNumber());
    }
}

