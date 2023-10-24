package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Questioner {

    private final GameNumber targetNumber;

    public Questioner() {
        this.targetNumber = generateTargetNumber();
    }

    private static GameNumber generateTargetNumber() {

        while (true) {
            int randInt = Randoms.pickNumberInRange(100, 999);
            String currentTargetNumber = String.valueOf(randInt);

            try {
                return GameNumber.from(currentTargetNumber);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }


}
