package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private String answer;
    private String userInput;
    private int ball;
    private int strike;

    Game() {
        this.ball = 0;
        this.strike = 0;
    }

    public void pickRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.answer = computer.toString().replaceAll("[^0-9]", "");
    }

}
