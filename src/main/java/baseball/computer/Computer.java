package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private Ball balls;

    public Computer() {
        balls = new Ball(Randoms.pickUniqueNumbersInRange(1, 9, 3));
    }
}
