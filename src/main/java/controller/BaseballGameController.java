package controller;

import model.BaseballGameModel;
import util.ComputerNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.BaseballGameView;

public class BaseballGameController {
    private final BaseballGameView baseballGameView = new BaseballGameView();
    private final BaseballGameModel baseballGameModel = new BaseballGameModel();
    private int isContinue = 1;

    public void doBaseballGame() {
        baseballGameView.printGameStartingMessage();

        while (isContinue == 1) {
            doBaseballGameOnce();

            baseballGameView.printGameClosingMessage();
            isContinue = baseballGameView.isContinue();
        }
    }

    private void doBaseballGameOnce() {
        List<Integer> computer = ComputerNumberGenerator.generate();
        List<Integer> userNumbers = new ArrayList<>();

        while (!computer.equals(userNumbers)) {
            userNumbers = baseballGameView.getUserNumberList();

            List<Integer> gameResult = baseballGameModel.compareComputerAndUserNumbers(computer, userNumbers);

            baseballGameView.printJudgementMessage(gameResult);
        }
    }
}
