package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int COUNT_ZERO = 0;
    private static final int COMPUTER_NUMBER_COUNT = 3;
    private static final int COMPUTER_NUMBER_MIN = 1;
    private static final int COMPUTER_NUMBER_MAX = 9;

    public int strikeCount;
    public int ballCount;

    public void calculateNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        strikeCount = COUNT_ZERO;
        ballCount = COUNT_ZERO;

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCount++;
            }
            if (computerNumbers.contains(playerNumbers.get(i)) && !computerNumbers.get(i)
                    .equals(playerNumbers.get(i))) {
                ballCount++;
            }
        }
    }

    public List<Integer> createComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(COMPUTER_NUMBER_MIN, COMPUTER_NUMBER_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}