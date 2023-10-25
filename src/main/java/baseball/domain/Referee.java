package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Referee {
    private static final String RESULT_NOTHING_MESSAGE = "낫싱";
    private static final String RESULT_BALL_MESSAGE = "볼";
    private static final String RESULT_STRIKE_MESSAGE = "스트라이크";
    private static final String CHARACTER_SPACING = " ";
    private static final int MAX_BALL_SIZE = 3;
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;
    private static final int ZERO_COUNT = 0;

    public boolean compareNumberByPlayerAndComputer(List<Integer> player, List<Integer> computer) {
        List<Integer> result = compare(player, computer);
        judge(result);

        return result.get(STRIKE_INDEX) != MAX_BALL_SIZE;
    }

    private void judge(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        int ballCount = result.get(BALL_INDEX);
        int strikeCount = result.get(STRIKE_INDEX);

        if (ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT) {
            sb.append(RESULT_NOTHING_MESSAGE);
        }
        if (ballCount > ZERO_COUNT) {
            sb.append(ballCount).append(RESULT_BALL_MESSAGE).append(CHARACTER_SPACING);
        }
        if (strikeCount > ZERO_COUNT) {
            sb.append(strikeCount).append(RESULT_STRIKE_MESSAGE);
        }

        System.out.println(sb.toString().trim());
    }

    private List<Integer> compare(List<Integer> player, List<Integer> computer) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < MAX_BALL_SIZE; i++) {
            if (computer.contains(player.get(i))) {
                if (computer.get(i).equals(player.get(i))) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }
        return Arrays.asList(ballCount, strikeCount);
    }
}
