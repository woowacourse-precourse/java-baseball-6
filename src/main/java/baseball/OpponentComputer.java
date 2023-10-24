package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class OpponentComputer {
    private final List<Integer> OpponentComputerNumber;

    public OpponentComputer() {
        this.OpponentComputerNumber = generateRandomNumber();
    }

    public List<Integer> getOpponentComputerNumber() {
        return OpponentComputerNumber;
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int[] calculateScore(User user) {
        List<Integer> userNumbers = user.getUserNumbers();
        List<Integer> opponentNumbers = getOpponentComputerNumber();

        int strikes = 0;
        int balls = 0;

        for (int userNumber : userNumbers) {
            int opponentNumber = opponentNumbers.get(userNumbers.indexOf(userNumber));

            if (userNumber == opponentNumber) {
                strikes++;
            } else if (opponentNumbers.contains(userNumber)) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }
}
