package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Questioner {

    private final GameNumber targetNumber;

    public Questioner() {
        this.targetNumber = generateTargetNumber();
    }

    private static GameNumber generateTargetNumber() {

        while (true) {
            StringBuilder targetNumber = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                targetNumber.append(Randoms.pickNumberInRange(1, 9));
            }

            if (GameNumber.isValid(targetNumber.toString())) {
                return GameNumber.from(targetNumber.toString());
            }
        }
    }
    public GameResult judge(GameNumber guessed) {
        return targetNumber.judge(guessed);
    }
}
