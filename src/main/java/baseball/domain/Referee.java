package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Referee {
    private static final int MAX_SIZE = 3;
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;

    public boolean compareNumberByPlayerAndComputer(List<Integer> player, List<Integer> computer) {
        List<Integer> result = compare(player, computer);
        judge(result);

        return result.get(STRIKE_INDEX) != MAX_SIZE;
    }

    private void judge(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        int ballCount = result.get(BALL_INDEX);
        int strikeCount = result.get(STRIKE_INDEX);

        if (ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }
        if (ballCount > 0) {
            sb.append(ballCount).append("볼").append(" ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }

        System.out.println(sb.toString().trim());
    }

    private List<Integer> compare(List<Integer> player, List<Integer> computer) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
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
