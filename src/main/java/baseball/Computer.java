package baseball;

import java.util.List;

public class Computer {

    private final List<Integer> target;

    private Boolean solved;

    public Computer(List<Integer> target) {
        this.target = target;
        this.solved = false;
    }

    public List<Integer> getTarget() {
        return target;
    }

    public Boolean getSolved() {
        return solved;
    }

    // 사용자가 컴퓨터의 수를 맞췄을 경우, 상태를 true로 바꿔준다.
    public void makeSolved() {
        this.solved = true;
    }
}
