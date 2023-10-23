package baseball.version2.controller;

import static baseball.version2.constants.Value.ANSWER_ARRAY_SIZE;
import static baseball.version2.constants.Value.THREE_STRIKE;

import baseball.version2.dto.ComputerAnswerDto;
import baseball.version2.dto.PlayerAnswerDto;
import baseball.version2.object.Score;
import baseball.version2.service.Service;
import baseball.version2.view.InputView;
import baseball.version2.view.OutView;

public class Controller {
    private final Service service;
    private final InputView inputView;
    private final OutView outView;

    public Controller() {
        this.service = new Service();
        this.inputView = new InputView();
        this.outView = new OutView();
    }

    public void runGame() {
        outView.printStart();
    }

    public ComputerAnswerDto settingGame() {
        ComputerAnswerDto computerAnswerDto = service.getComputerAnswer();
        return computerAnswerDto;
    }

    public boolean startGame(ComputerAnswerDto computerAnswer) {
        PlayerAnswerDto playerAnswer = inputView.getPlayerAnswer(ANSWER_ARRAY_SIZE);
        Score score = service.compareTwoAnswer(playerAnswer, computerAnswer);
        int strike = outView.printResult(score);

        if (strike == THREE_STRIKE) {
            return true;
        }
        return false;
    }

    public int isContinue() {
        return inputView.getPlayerDecision();
    }
}
