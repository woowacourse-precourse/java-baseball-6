package baseball.domain.comparator;

import baseball.domain.baseballnumber.BaseballNumber;
import baseball.domain.baseballnumber.BaseballNumbers;
import baseball.domain.compararesult.CompareResult;
import baseball.domain.computer.Computer;
import baseball.domain.player.Player;

public class Comparator {

    private static final int BASEBALL_NUMBER_SIZE = 3;

    private final BaseballNumbers computerNumbers;
    private final BaseballNumbers playerNumbers;
    private final CompareResult compareResult = new CompareResult();

    public Comparator(Computer computer, Player player) {
        this.computerNumbers = computer.numbers();
        this.playerNumbers = player.numbers();
    }

    public CompareResult compare() {
        for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
            BaseballNumber playerNumber = playerNumbers.get(i);
            checkBall(playerNumber, i);
            checkStrike(playerNumber, i);
        }
        return compareResult;
    }

    private void checkBall(BaseballNumber playerNumber, int index) {
        if (computerNumbers.containsWithDifferentIndex(playerNumber, index)) {
            compareResult.addBall();
        }
    }

    private void checkStrike(BaseballNumber playerNumber,int index) {
        if (computerNumbers.containsWithSameIndex(playerNumber, index)) {
            compareResult.addStrike();
        }
    }
}
