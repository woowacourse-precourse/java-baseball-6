package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    static final int NUMBER_OF_DIGITS = 3;
    static final AnswerNumber ANSWER_NUMBER = new AnswerNumber();
    private CountController countController = new CountController();
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void createAnswer() {
        ANSWER_NUMBER.createRandomNumberList();
        System.out.println("정답: " + ANSWER_NUMBER.getRandomNumber());
    }

    public void startGame() {
        System.out.println(outputView.printStart());
        createAnswer();
        proceedGame();
    }

    public void proceedGame() {
        InputNumber inputNumber;

        do {
            inputNumber = new InputNumber();
            inputNumber.setInputNumber(inputView.getPlayerInput());
            System.out.println("사용자 입력: " + inputNumber.getInputNumber());

            String hintMessage = outputView.printHint(countController.getHintMessage(inputNumber));
            System.out.println(hintMessage);

        } while (!isDone(inputNumber));

        inputNumber.setQuitNumber(inputView.getRestartOrQuitInput());

        if (!isQuit(inputNumber)) {
            startGame();
        }

    }

    public boolean isDone(InputNumber inputNumber) {
        if (countController.getStrikeCount(inputNumber) == NUMBER_OF_DIGITS) {
            System.out.println(outputView.printSuccess());
            return true;
        }
        return false;
    }

    public boolean isQuit(InputNumber inputNumber) {
        if (inputNumber.getQuitNumber().equals("2")) {
            return true;
        }
        return false;
    }
}