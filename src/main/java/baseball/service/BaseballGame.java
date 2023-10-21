package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {


    private static final int COUNT_ZERO = 0;
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
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}