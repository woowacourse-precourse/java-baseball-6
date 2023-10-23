package baseball.model;

import baseball.controller.ViewController;

public class Referee {
    private static int OFFSET = 3;

    private final ViewController viewController;

    public Referee(ViewController viewController) {
        this.viewController = viewController;
    }

    public boolean judgeGameOver(int[] userNumberArray, int[] computerNumberArray) {
        int ball = countBall(userNumberArray, computerNumberArray);
        int strike = countStrike(userNumberArray, computerNumberArray);
        viewController.printResultMessage(ball, strike);
        if (strike == OFFSET) {
            viewController.printFinishMessage();
            return true;
        }
        return false;
    }

    private int countStrike(int[] userNumberArray, int[] computerNumberArray) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userNumberArray[i] == computerNumberArray[j] && i == j) {
                    cnt++;

                }
            }
        }
        return cnt;
    }

    private int countBall(int[] userNumberArray, int[] computerNumberArray) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userNumberArray[i] == computerNumberArray[j] && i != j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
