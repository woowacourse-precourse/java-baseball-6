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

    public void announceEndGame() {
        printEndGameComment();
    }

    public boolean checkPlayerWantRestart(Player player) {
        printRestartGameComment();
        return player.chooseFinishGame();
    }

    public Result makeResult(List<Integer> playerNumbers, List<Integer> answer) {
        int duplicateCount = countDuplicateIntegers(playerNumbers, answer);
        int strikeCount = countStrike(playerNumbers, answer);
        int ballCount = calculateBall(duplicateCount, strikeCount);

        return new Result(strikeCount, ballCount);
    }

    private int countDuplicateIntegers(List<Integer> playerNumbers, List<Integer> answer) {
        int duplicateCount = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.contains(playerNumbers.get(i))) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private int countStrike(List<Integer> playerNumbers, List<Integer> answer) {
        int strikeCount = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.get(i) == playerNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int calculateBall(int duplicateCount, int strikeCount) {
        return duplicateCount - strikeCount;
    }

    public boolean checkGameIsFinish(Result result) {
        return result.isAllStrike();
    }
}
