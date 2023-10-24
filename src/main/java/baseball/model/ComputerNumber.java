package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MAX_NUMBER_LENGTH = 3;

    List<Integer> computerNumberList;

    public ComputerNumber() {
        setGameClearNumber();
    }

    public void setGameClearNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < MAX_NUMBER_LENGTH) {
            int randNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!computerNumbers.contains(randNumber)) {
                computerNumbers.add(randNumber);
            }
        }
        this.computerNumberList = computerNumbers;
    }

    public List<Integer> getComputerNumberList() {
        return computerNumberList;
    }
}


