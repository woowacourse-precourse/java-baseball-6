package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final BaseballMachine baseballMachine;
    private final UserNumber userNumber;

    private GameManager(BaseballMachine baseballMachine, UserNumber userNumber) {
        this.baseballMachine = baseballMachine;
        this.userNumber = userNumber;
    }

    public static GameManager getInstance(BaseballMachine baseballMachine, UserNumber userNumber) {
        return new GameManager(baseballMachine, userNumber);
    }

    public List<Integer> gameResult() {
        List<Integer> gameResult = new ArrayList<>();
        gameResult.add(machineBallCount());
        gameResult.add(machineStrikeCount());
        return gameResult;
    }

    public int machineStrikeCount() {
        return baseballMachine.strikeCount(userNumber.getNumbers());
    }

    private int machineBallCount() {
        return baseballMachine.ballCount(userNumber.getNumbers());
    }

    public boolean hasAllStrike() {
        return baseballMachine.hasAllMatched(userNumber.getNumbers());
    }
}
