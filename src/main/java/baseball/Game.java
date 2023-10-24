package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public final List<Integer> answerList;

    public Game() {
        answerList = makeRandomAnswer();
    }

    public List<Integer> makeRandomAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public GameResult getGameResult(List<Integer> userInputList) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (answerList.get(i).equals(userInputList.get(i))) {
                strike++;
            } else if (answerList.contains(userInputList.get(i))) {
                ball++;
            }
        }

        return new GameResult(strike, ball);
    }
}
