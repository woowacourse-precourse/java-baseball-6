package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;

public class GameController {
    static final AnswerNumber answerNumber = new AnswerNumber();
    static InputNumber inputNumber = new InputNumber();

    public void createAnswer() {
        answerNumber.createRandomNumberList();
        System.out.println("정답: " + answerNumber.getRandomNumber());
    }

    public void 시작입력() { //없애야함
        inputNumber.setInputNumber("352");
        System.out.println("사용자 입력: " + inputNumber.getInputNumber());
    }

}

