package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer implements Player {
    private List<Integer> randomNumbers;

    public ComputerPlayer() {
        this.randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    @Override
    public List<Integer> getNumbers() {
        return this.randomNumbers;
    }
}
