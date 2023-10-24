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
        if (!isContained(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    private boolean isContained(int randomNumber) {
        return numbers.contains(randomNumber);
    }

    private boolean isCompleted() {
        return numbers.size() == NUMBER_SIZE;
    }

}
