package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallsFactory {

    public static Balls createComputerBalls() {
        List<Integer> computerNumbers = createComputerNumber();
        return new Balls(computerNumbers);
    }

    public static Balls createPlayerBalls(List<Integer> playerNumbers) {
        return new Balls(playerNumbers);
    }

    private static List<Integer> createComputerNumber() {
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
