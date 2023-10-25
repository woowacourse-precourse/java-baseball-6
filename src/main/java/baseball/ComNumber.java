package baseball;

import camp.nextstep.edu.missionutils.Randoms;


public class ComNumber {
    int[] comNumber = new int[3];

    public int makeComNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        return randomNumber;
    }
}