package baseball.core.rule;

import java.util.List;

public class PickedNumbers {

    private final List<Integer> opponentNumberList;
    private final List<Integer> playerNumberList;

    public static PickedNumbers createPickedNumbers(List<Integer> opponentNumberList,
        List<Integer> playerNumberList) {
        return new PickedNumbers(opponentNumberList, playerNumberList);
    }

    protected PickedNumbers(List<Integer> opponentNumberList, List<Integer> playerNumberList) {
        this.opponentNumberList = opponentNumberList;
        this.playerNumberList = playerNumberList;
    }

    public List<Integer> getOpponentNumberList() {
        return opponentNumberList;
    }

    public List<Integer> getPlayerNumberList() {
        return playerNumberList;
    }
}
