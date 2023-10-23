package baseball.domain;

import java.util.List;

public class Computer {
    private final List<Integer> ballList;

    public Computer(List<Integer> ballList) {
        this.ballList = ballList;
    }

    public List<Integer> getBallList() {
        return ballList;
    }
}
