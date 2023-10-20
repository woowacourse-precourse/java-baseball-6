package baseball.controller;

import baseball.exception.Exception;
import baseball.domain.Score;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Integer> computer = new ArrayList<>();
    Score score = new Score();

    public void init() {
        makeComputerNumber();
    }
    public Score getScore (String input) {

        Exception.checkException(input);

        score.checkStrike(input, computer);
        score.checkBall(input, computer);

        return score;
    }

    private void makeComputerNumber() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    };

}
