package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computerNumbers;

    public Game() {
        computerNumbers = generateComputerNumbers();
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int[] playRound(List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userGuess.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userGuess.get(i))) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }
}
