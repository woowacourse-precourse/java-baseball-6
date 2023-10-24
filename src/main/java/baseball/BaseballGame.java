package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballGame {

    private static final int STRIKE_IDX = 0;
    private static final int BALL_IDX = 1;
    private static final int NOTHING_IDX = 2;

    private Computer computer;
    private Player player;

    public boolean isStrike(int playerNum, int idx, List<Integer> computerNums) {
        return computerNums.get(idx) == playerNum;
    }

    public boolean isBall(int playerNum, int idx, List<Integer> computerNums) {
        return computerNums.contains(playerNum) && computerNums.get(idx) != playerNum;
    }


    public boolean isNothing(int playerNum, List<Integer> computerNums) {
        return !computerNums.contains(playerNum);
    }

    public List<Integer> calcResult(List<Integer> computerNums, List<Integer> playerNums) {
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0));

        for (int idx = 0; idx < playerNums.size(); idx++) {
            countStrike(computerNums, playerNums, results, idx);
            countBall(computerNums, playerNums, results, idx);
            countNothing(computerNums, playerNums, results, idx);
        }

        return Collections.unmodifiableList(results);
    }

    private void countNothing(List<Integer> computerNums, List<Integer> playerNums, ArrayList<Integer> results, int idx) {
        if(isNothing(playerNums.get(idx), computerNums)) results.set(NOTHING_IDX, results.get(NOTHING_IDX)+1);
    }

    private void countBall(List<Integer> computerNums, List<Integer> playerNums, ArrayList<Integer> results, int idx) {
        if(isBall(playerNums.get(idx), idx, computerNums)) results.set(BALL_IDX, results.get(BALL_IDX)+1);
    }

    private void countStrike(List<Integer> computerNums, List<Integer> playerNums, ArrayList<Integer> results, int idx) {
        if(isStrike(playerNums.get(idx), idx, computerNums)) results.set(STRIKE_IDX, results.get(STRIKE_IDX)+1);
    }
}
