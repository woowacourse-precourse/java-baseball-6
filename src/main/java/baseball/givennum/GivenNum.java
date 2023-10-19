package baseball.givennum;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GivenNum {
    private List<Integer> computerNumbers;

    public GivenNum() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public int[] getComputerNumbersAsArray() {
        int[] result = new int[computerNumbers.size()];
        for (int i = 0; i < computerNumbers.size(); i++) {
            result[i] = computerNumbers.get(i);
        }
        return result;
    }
}
