package baseball;

public class CompareSystem {
    private final GameResult result = new GameResult();
    private final Computer computer;
    private final Player player;

    public CompareSystem(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public GameResult compare() {
        for(int index = 0; index < 3; index++) {
            CompareStatus compareStatus = checkStatus(index);
            int compareCount = result.get(compareStatus);
            result.set(compareStatus, compareCount+1);
        }
        return result;
    }

    private CompareStatus checkStatus(int index) {
        if(isNumberComputerContains(index)) {
            return checkBallOrStrike(index);
        }
        return CompareStatus.NOTHING;
    }

    private CompareStatus checkBallOrStrike(int index) {
        if(isSamePositionAndSameNumber(index)) {
            return CompareStatus.STRIKE;
        }
        return CompareStatus.BALL;
    }

    private boolean isSamePositionAndSameNumber(int index) {
        return computer.get(index) == player.get(index);
    }

    private boolean isNumberComputerContains(int index) {
        return computer.contains(player.get(index));
    }
}
