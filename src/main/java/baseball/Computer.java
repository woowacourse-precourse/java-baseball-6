package baseball;

import camp.nextstep.edu.missionutils.Randoms;

class Computer {
    private Randoms randoms;

    public Computer() {

    }

    public int generateRandomNumber() {
        return randoms.pickNumberInRange(100, 999);
    }
}
