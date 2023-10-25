package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer extends Number {
    public Computer() {
        super();
        makeNumbers();
    }

    private void makeNumbers() {
        while (!isCompleted()) {
            putRandomNumber();
        }
    }

    private void putRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        putNumber(randomNumber);
    }

}
