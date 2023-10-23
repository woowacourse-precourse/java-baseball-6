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

    public void startGame() {
        printController.printStart();
        createAnswer();
        proceedGame();
    }

    public void proceedGame() {
        InputNumber inputNumber = new InputNumber();

        int i = 0;
        do {
            //뷰로 입력 받기 - 임시로 테스트 케이스 작성
            inputNumber.setInputNumber("516");
            System.out.println("사용자 입력: " + inputNumber.getInputNumber());

            System.out.println(printController.printCount(inputNumber));

            i++;
        } while (i < 3); //!isDone 검증 메서드

        //뷰로 입력 받기 - 임시로 테스트 케이스 작성
        inputNumber.setQuitNumber("2");

        if (!isQuitted(inputNumber)) {
            startGame();
        }

    }

    public boolean isDone(InputNumber inputNumber) {
        if (countController.getStrikeCount(inputNumber) == 3) {
            System.out.println(printController.printSuccess());
            return true;
        }
        return false;
    }

    public boolean isQuitted(InputNumber inputNumber) {
        if (inputNumber.getQuitNumber().equals("2")) {
            return true;
        }
        return false;
    }
}

