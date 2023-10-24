package baseball;

import java.util.List;

public class GameResult {
    private static final GameResult gameResult = new GameResult();

    private GameResult() {
    }
    public static GameResult getGameResult() {
        return gameResult;
    }

    public int[] countResult(String input, List<Integer> list) {
        int[] countArr = new int[]{0, 0};
        for (int i = 0; i < list.size(); i++) {
            int inputNum = input.charAt(i) - '0';
            if (list.get(i) == inputNum) countArr[0]++; // strike
            else if (list.contains(inputNum)) countArr[1]++; // ball
        }
        return countArr;
    }
}
