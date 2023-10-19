package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> computer = new ArrayList<>();

    public Game() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public boolean play(List<Integer> number) {
        int ballCount = countBall(number);
        int strikeCount = countStrike(number);
        return false;
    }

    private int countBall(List<Integer> number) {
        int count = 0;
        for (int i = 0; i < number.size(); i++) {
            for (int j = 0; j < computer.size(); j++) {
                if (i != j && number.get(i).equals(computer.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countStrike(List<Integer> number) {
        int count = 0;
        for (int i = 0; i < number.size(); i++) {
            if (number.get(i).equals(computer.get(i))) {
                count++;
            }
        }
        return count;
    }

}
