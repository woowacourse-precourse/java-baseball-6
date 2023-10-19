package baseball.Game;

import java.util.List;

public class GameRule {
    private boolean endGame;

    public boolean gameLogic(List<Integer> attempt, List<Integer> target) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < attempt.size(); i++) {
            if (attempt.get(i).equals(target.get(i))) {
                strike++;
            }
            else if (target.contains(attempt.get(i))) {
                ball++;
            }
        }
        gameResult(ball, strike);

        return endGame;
    }

    private void gameResult(int ball, int strike) {
        if (strike == 3) {
            printAllStrike();
            endGame=true;
            return;
        }

        endGame=false;

        if (ball == 0 && strike == 0) {
            printNothing();
            return;
        }

        printProceeding(ball, strike);
    }

    private void printAllStrike() {
        System.out.println("3스트라이크");
    }

    private void printNothing() {
        System.out.println("낫싱");
    }

    private void printProceeding(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }
}
