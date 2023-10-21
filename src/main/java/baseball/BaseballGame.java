package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int NUMBER_SIZE = 3;
    private int[] numbers = new int[NUMBER_SIZE];

    public BaseballGame() {
        setNumber();
    }

    private void setNumber(){
        for (int i = 0; i < NUMBER_SIZE; i++) {
            numbers[i] = pickNumberInRange(START_NUMBER, END_NUMBER);
        }
    }
}
