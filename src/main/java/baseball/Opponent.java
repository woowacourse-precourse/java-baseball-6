package baseball;

import baseball.verification.Verification;
import camp.nextstep.edu.missionutils.Randoms;

public class Opponent {
    private Verification verification = new Verification();

    public int[] makeRandomNumber() {
        int[] randomNumbers = new int[3];
        boolean isValid = false;

        while (!isValid) {
            randomNumbers[0] = Randoms.pickNumberInRange(1, 9);
            randomNumbers[1] = Randoms.pickNumberInRange(0, 9);
            randomNumbers[2] = Randoms.pickNumberInRange(0, 9);

            isValid = verification.checkRandomValid(randomNumbers);
        }
        return randomNumbers;
    }
}
