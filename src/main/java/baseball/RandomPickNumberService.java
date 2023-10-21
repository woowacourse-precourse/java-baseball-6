package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPickNumberService {

    private NumbersObjects computerNumbers;

    public RandomPickNumberService(NumbersObjects computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public void randomPick(int numOfNumbers) {
        while (computerNumbers.size() < numOfNumbers) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
}
