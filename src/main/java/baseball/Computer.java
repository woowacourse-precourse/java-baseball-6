package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public RandomNumbers createRandomBalls() {
        RandomNumbers randomNumbers = new RandomNumbers();
        while (!randomNumbers.isFull()) {
            Number newNumber = new Number(Randoms.pickNumberInRange(1, 9));
            if (!randomNumbers.contains(newNumber)) {
                randomNumbers.add(newNumber);
            }
        }
        return randomNumbers;
    }
}
