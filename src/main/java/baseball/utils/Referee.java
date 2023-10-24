package baseball.utils;

import java.util.List;

public class Referee {
    private static final int THREE_STRIKE = 3;
    private final NumberCompare numberCompare;

    public Referee() {
        numberCompare = new NumberCompare();
    }

    public int[] getNumberCompare(List<Integer> playerNumber, List<Integer> computerNumber) {
        return numberCompare.getNumberCompareResult(playerNumber, computerNumber);
    }

    public boolean isThreeStrike() {
        if (numberCompare.getStrike() == THREE_STRIKE) {
            return true;
        }
        return false;
    }

}
