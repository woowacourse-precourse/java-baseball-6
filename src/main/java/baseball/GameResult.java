package baseball;

import java.util.List;

public class GameResult {
    private static final GameResult gameResult = new GameResult();

    private GameResult() {
    }

    public int[] countResult(String input, List<Integer> list) {
        int[] countArr = new int[]{0, 0};
        char[] chars = input.toCharArray();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == chars[i] - '0') countArr[0]++; // strike
            else if (list.contains(chars[i] - '0')) countArr[1]++; // ball
        }
        return countArr;
    }

    public static GameResult getGameResult() {
        return gameResult;
    }
}
