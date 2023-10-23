package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Computer {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    private List<Integer> computerNumber;

    public Computer() {
        computerNumber = new ArrayList<>();
    }

    public void createOne() {
        int number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (!validDuplication(number)) {
            computerNumber.add(number);
        }
    }

    public boolean validDuplication(int number) {
        if (computerNumber.contains(number)) {
            return true;
        }
        return false;
    }

    public void reset() {
        computerNumber.clear();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

}