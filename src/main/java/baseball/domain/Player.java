package baseball.domain;

import java.util.List;

public class Player {
    private final List<Integer> ballList;

    public Player(List<Integer> ballList) {
        this.ballList = ballList;
    }

    public String getBallNumber() {
        return String.format("%d%d%d", ballList.get(0), ballList.get(1), ballList.get(2));
    }
}
