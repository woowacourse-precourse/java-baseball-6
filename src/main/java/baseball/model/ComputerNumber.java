package baseball.model;

import baseball.util.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final List<Integer> computerNumber;

    public ComputerNumber() {
        computerNumber = generateComputerNumber();
    }

    private List<Integer> generateComputerNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < Constants.BALL_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Constants.MIN_BALL_NUMBER, Constants.MAX_BALL_NUMBER);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public int getSize() {
        return computerNumber.size();
    }

    public boolean hasDuplicatedNumber() {
        return computerNumber.size() != computerNumber.stream().distinct().count();
    }

}
