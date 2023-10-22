package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    // 입력받는 리스트와 컴퓨터의 리스트를 비교해서 스트라이크/볼/낫싱 판단
    // [스트라이크 개수, 볼 개수]
    public List<Integer> guessNumbers(List<Integer> guess) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i< 3; i++) {
            if (guess.get(i).equals(target.get(i))) {
                strike += 1;
            }
            else if (target.contains(guess.get(i))) {
                ball += 1;
            }
        }

        return new ArrayList<>(Arrays.asList(strike, ball));
    }
}
