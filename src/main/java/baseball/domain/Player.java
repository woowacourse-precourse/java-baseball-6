package baseball.domain;

import java.util.List;

public class Player {
    private final List<Integer> ballList;

    public Player(List<Integer> ballList) {
        this.ballList = ballList;
    }

    public List<Integer> getBallList() {
        return ballList;
    }
}
