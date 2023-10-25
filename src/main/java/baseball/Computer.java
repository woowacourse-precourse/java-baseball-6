package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int INPUT_LENGTH = 3;

    int[] computerBaseBallNumber = new int[INPUT_LENGTH];

    public void generateComputerBaseBallNumber() {
        Integer[] randomBaseBallNumber = Randoms.pickUniqueNumbersInRange(1, 9, INPUT_LENGTH).toArray(Integer[]::new);
        for (int i = 0; i < INPUT_LENGTH; i++) {
            this.computerBaseBallNumber[i] = randomBaseBallNumber[i];
        }
    }
}
