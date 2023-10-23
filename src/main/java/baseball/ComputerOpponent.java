package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerOpponent implements Opponent {
    private List<Integer> answer;

    public ComputerOpponent() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    @Override
    public BaseballResult guess(List<Integer> userGuess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            Integer pieceOfGuess = userGuess.get(i);

            if (pieceOfGuess.equals(answer.get(i))) {
                // strike
                strike = strike + 1;
            } else {
                // ball or not
                if (answer.contains(pieceOfGuess)) {
                    // ball
                    ball = ball + 1;
                }
            }
        }
        return new BaseballResult(strike, ball);
    }
}
