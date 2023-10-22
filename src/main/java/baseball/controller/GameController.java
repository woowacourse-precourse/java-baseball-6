package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;

public class GameController {
    static final AnswerNumber answerNumber = new AnswerNumber();
    private PrintController printController = new PrintController();
    private CountController countController = new CountController();

    public void createAnswer() {
        answerNumber.createRandomNumberList();
        System.out.println("정답: " + answerNumber.getRandomNumber());
    }

    public void proceedGame() { //임시로 테스트 케이스 작성
        int i = 0;
        do {
            //뷰로 입력 받기
            InputNumber inputNumber = new InputNumber();
            inputNumber.setInputNumber("516");
            System.out.println("사용자 입력: " + inputNumber.getInputNumber());

            System.out.println(printController.printCount(inputNumber));

            i++;
        } while (i < 3); //!isDone 검증 메서드
    }
}

