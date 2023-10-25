package baseball.domain;

import java.util.List;

public class Computer {
    private List<Integer> computerBall;

    public List<Integer> getComputerBall() {
        return computerBall;
    }

    public void createComputerBall(List<Integer> computer) {
        this.computerBall = computer;
    }
}
