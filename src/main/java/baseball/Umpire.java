package baseball;

import java.util.List;

public class Umpire {

    private static final int INIT_NUMBER = 0;
    private static final int MAX_NUMBER_SIZE = 3;

    public int getStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = INIT_NUMBER;
        for (int i = INIT_NUMBER; i < MAX_NUMBER_SIZE; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            }
        }
        return strike;
    }
}
