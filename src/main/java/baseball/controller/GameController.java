package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final String QUIT_NUMBER = "2";
    private final CountController countController = new CountController();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public AnswerNumber createAnswer() {
        AnswerNumber answerNumber = new AnswerNumber();
        answerNumber.setRandomNumber();
        return answerNumber;
    }

    public void startGame() {
        outputView.printStart();
        proceedGame();
    }

    public void proceedGame() {
        AnswerNumber answerNumber = createAnswer();
        InputNumber inputNumber;

        do {
            inputNumber = new InputNumber();
            inputNumber.setInputNumber(inputView.getPlayerInput());
            outputView.printHint(countController.getHintMessage(inputNumber, answerNumber));
        } while (!isDone(inputNumber, answerNumber));

        inputNumber.setQuitNumber(inputView.getRestartOrQuitInput());
        if (!inputNumber.isQuit()) {
            proceedGame();
        }
    }

    public boolean isDone(InputNumber inputNumber, AnswerNumber answerNumber) {
        if (countController.isSucceeded(inputNumber, answerNumber)) {
            outputView.printSuccess();
            return true;
        }
        return false;
    }
}