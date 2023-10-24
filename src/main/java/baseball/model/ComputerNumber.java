package baseball.model;

import baseball.util.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final List<BallNumber> computerNumber;

    public ComputerNumber() {
        computerNumber = generateComputerNumber();
    }

    private List<BallNumber> generateComputerNumber() {
        List<BallNumber> numberList = new ArrayList<>();
        while (numberList.size() < Constants.BALL_LENGTH) {
            BallNumber randomBallNumber = new BallNumber(
                    Randoms.pickNumberInRange(Constants.MIN_BALL_NUMBER, Constants.MAX_BALL_NUMBER));
            if (!numberList.contains(randomBallNumber)) {
                numberList.add(randomBallNumber);
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

    public BallNumber getNumberByPosition(int position) {
        return computerNumber.get(position);
    }

    public boolean hasNumber(BallNumber ballNumber) {
        return computerNumber.contains(ballNumber);
    }

}
