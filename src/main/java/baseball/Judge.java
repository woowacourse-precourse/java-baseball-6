package baseball;

import java.util.List;

import static baseball.Printer.*;

public class Judge {
    public void announceStartGame() {
        printStartGameComment();
    }

    public void announceResult(Result result) {
        printRoundResult(result);
    }

    public void announceGameOver() {
        printEndGameComment();
    }

    public boolean checkGameOver(Result result) {
        return result.isAllStrike();
    }

    public boolean checkRestart(Player player) {
        printRestartGameComment();
        return player.chooseFinishGame();
    }

    public Result makeResult(List<Integer> playerNumbers, List<Integer> answer) {
        int duplicate = countDuplicateIntegers(playerNumbers, answer);
        int strike = countStrike(playerNumbers, answer);
        int ball = calculateBall(duplicate, strike);

        return new Result(strike, ball);
    }

    private int countDuplicateIntegers(List<Integer> playerNumbers, List<Integer> answer) {
        int duplicate = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.contains(playerNumbers.get(i))) {
                duplicate++;
            }
        }
        return duplicate;
    }

    private int countStrike(List<Integer> playerNumbers, List<Integer> answer) {
        int strike = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.get(i) == playerNumbers.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBall(int duplicate, int strike) {
        return duplicate - strike;
    }
}
