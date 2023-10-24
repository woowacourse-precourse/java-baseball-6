package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final int[] numbers = new int[3];

    public Computer() {
        for (int i = 0; i < 3; i++) {
            this.numbers[i] = Randoms.pickNumberInRange(1, 9);
        }
    }

    public int[] getNumbers() {
        return this.numbers;
    }

}
