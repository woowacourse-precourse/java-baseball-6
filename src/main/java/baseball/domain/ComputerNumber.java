package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    List<Integer> computerNumbers;

    public ComputerNumber() {
        makeRandomNumber();
    }

    public void makeRandomNumber() {
        List<Integer> randoms = new ArrayList<>();
        while (randoms.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randoms.contains(randomNumber)) {
                randoms.add(randomNumber);
            }
        }
        computerNumbers = randoms;
    }

    public boolean isNumberContains(int number) {
        return computerNumbers.contains(number);
    }

    public int getNumberIndex(int number) {
        return computerNumbers.indexOf(number);
    }

}
