package baseball.numbers;

import baseball.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbersGenerator extends NumbersGenerator{

    public List<Integer> createNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < Constants.BASEBALL_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constants.COMPUTER_NUMBER_START, Constants.COMPUTER_NUMBER_END);
            addRandomNumber(computerNumbers, randomNumber);
        }
        return computerNumbers;
    }

    private void addRandomNumber(List<Integer> computerNumbers, int randomNumber) {
        if (!computerNumbers.contains(randomNumber)) {
            computerNumbers.add(randomNumber);
        }
    }
}