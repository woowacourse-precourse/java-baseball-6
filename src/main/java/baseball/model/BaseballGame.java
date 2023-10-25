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

    public String playRound(List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        if (strikes > 0 && balls > 0) {
            return balls + "볼 " + strikes + "스트라이크";
        } else if (strikes > 0) {
            return strikes + "스트라이크";
        } else if (balls > 0) {
            return balls + "볼";
        } else {
            return "낫싱";
        }
    }

}