package baseball.domain;

import java.util.List;

public class CompareNumbers {
    private final List<Integer> computer;
    private final List<Integer> player;

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    public CompareNumbers(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
    }

    private int totalHitsCount() {
        int count = 0;
        for (int num : player) {
            if (computer.contains(num)) count++;
        }
        return count;
    }

    private int strikeCount() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(player.get(i))) count++;
        }
        return count;
    }

    public String generateResult() {
        int totalHits = totalHitsCount();
        int strike = strikeCount();
        int ball = totalHits - strike;

        if (totalHits == 0) return NOTHING;
        if (strike == 0) return ball + BALL;
        if (ball == 0) return strike + STRIKE;
        return ball + BALL + " " + strike + STRIKE;
    }
}
