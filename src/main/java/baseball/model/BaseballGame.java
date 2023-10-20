package baseball.model;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;

    public BaseballGame() {
        computerNumbers = generateRandomComputerNumbers();
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    private List<Integer> generateRandomComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

}