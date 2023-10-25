package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Catcher extends Player {
    @Override
    public void setNumbers() {
        clearNumbers();
        generateRandomNumbers();
    }

    public void clearNumbers() {
        numbers.clear();
    }

    public void generateRandomNumbers() {
        while (numbers.size() < Constant.MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!isNumbersContains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public boolean isNumbersContains(int number) {
        return numbers.contains(number);
    }
}
