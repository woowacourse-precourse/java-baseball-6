package baseball.domain;

import java.util.List;

public class Computer {
    private final List<Integer> ballList;

    public Computer(List<Integer> ballList) {
        this.ballList = ballList;
    }

    public String getBallNumber() {
        return String.format("%d%d%d", ballList.get(0), ballList.get(1), ballList.get(2));
    }
}
