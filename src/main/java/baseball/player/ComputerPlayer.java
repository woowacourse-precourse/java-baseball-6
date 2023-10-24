package baseball.player;

import baseball.common.Constants;
import baseball.game.StrikeBall;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer {
    private List<Integer> numbers = new ArrayList<>();

    public ComputerPlayer() {
        generateNumbers();
    }

    public List<Integer> getComputerNumber() {
        return numbers;
    }

    public void generateNumbers() {
        while(numbers.size() < Constants.maxNumDigit) {
            int randomNumber = Randoms.pickNumberInRange(Constants.startNum, Constants.lastNum);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public StrikeBall compareTo(List<Integer> userNumbers) {
        int strike = 0, ball = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            if (numbers.get(i).equals(userNumbers.get(i))) {
                strike++;
            } else if (numbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }

        return new StrikeBall(strike, ball);
    }
}
