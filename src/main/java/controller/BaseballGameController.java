package controller;

import util.ComputerNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.BaseballGameView;

public class BaseballGameController {
    private final BaseballGameView baseballGameView = new BaseballGameView();
    private int isContinue = 1;

    public void repeatBaseballGame() {
        baseballGameView.printGameStartingMessage();

        while (isContinue == 1) {
            doBaseballGame();

            baseballGameView.printGameClosingMessage();
            isContinue = baseballGameView.isContinue();
        }
    }

    private void doBaseballGame() {
        List<Integer> computer = ComputerNumberGenerator.generate();

        List<Integer> userNumbers = new ArrayList<>();

        while (!computer.equals(userNumbers)) {
            userNumbers = baseballGameView.getUserNumberList();

            int strikeCount = 0;
            int ballCount = 0;

            for (int i = 0; i < 3; i++) {
                if (userNumbers.get(i).equals(computer.get(i))) {
                    strikeCount ++;
                } else if (computer.contains(userNumbers.get(i))) {
                    ballCount ++;
                }
            }

            baseballGameView.printJudgementMessage(strikeCount, ballCount);
        }
    }
}
