package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class GameProcessor {

    private static final int INITIAL_RANDOM_NUMBER = 1;
    private static final int LAST_RANDOM_NUMBER = 9;

    private static int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(INITIAL_RANDOM_NUMBER, LAST_RANDOM_NUMBER);
        return generateRandomNumber();
    }

    public void IllegalArgumentException(Data data) {
        if ((data.getInputData().length()) > 3) {
            System.out.println("3보다 큽니다");
        }
    }


}
