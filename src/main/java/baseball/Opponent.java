package baseball;

import baseball.verification.Verification;
import camp.nextstep.edu.missionutils.Randoms;

public class Opponent {
    private Verification verification = new Verification();

    public int makeRandomNumber() {
        int randomNumber = 0;
        boolean isValid = false;

        while (!isValid) {
            randomNumber = Randoms.pickNumberInRange(100, 999);
            isValid = verification.checkRandomValid(randomNumber);
        }
        return randomNumber;
    }
}
