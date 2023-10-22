package baseball.version2.controller;


import static baseball.version2.Constants.Value.*;

import baseball.version2.service.Service;
import baseball.version2.view.InputView;
import baseball.version2.view.OutView;
import java.util.ArrayList;

public class Controller {

    private final Service service;
    private final InputView inputView;
    private final OutView outView;

    public Controller() {
        this.service = new Service();
        this.inputView = new InputView();
        this.outView = new OutView();

    }

    public void settingGame() {
        ArrayList<Integer> computerAnswer = service.getComputerAnswer();
        service.saveComputerAnswer(computerAnswer);
        outView.printStart();
    }

    public boolean startGame() {
        int[] playerAnswer = inputView.getPlayerAnswer(ANSWER_ARRAY_SIZE);
        service.compareTwoAnswer(playerAnswer);
        int strike = outView.printResult(service.getResult());
        service.initScoreRepository();
        if (strike == THREE_STRIKE) {
            return true;
        }
        return false;
    }

    public int isContinue() {
        return inputView.getPlayerDecision();
    }


}
