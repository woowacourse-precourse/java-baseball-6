package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final List<Integer> numberList;
    private final static int SIZE = 3;
    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 9;

    private ComputerNumber(List<Integer> numberList) {
        this.numberList = numberList;
    }
    public static ComputerNumber getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new ComputerNumber(computer);
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
