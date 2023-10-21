package baseball.view;

import baseball.controller.ScoreHandler;

public class ScoreViewer {

    public ScoreViewer(ScoreHandler scoreHandler) {
        if (scoreHandler.getStrike() == 0 && scoreHandler.getBall() == 0) {
            System.out.println("낫싱");
            return;
        }
        if (scoreHandler.getBall() != 0) System.out.print(scoreHandler.getBall() + "볼 ");
        if (scoreHandler.getStrike() != 0) System.out.print(scoreHandler.getStrike() + "스트라이크");

        System.out.println();
    }
}
