package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerAnswer;

    public void makeRandomNum() {

        computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < Constants.ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
    }

    public int computeStrike(int[] userNum) {
        int strike = 0;
        for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
            if (computerAnswer.get(i) == userNum[i]) {
                strike++;
            }
        }
        return strike;
    }

    public int computeBall(int[] userNum) {
        int ball = 0;
        for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
            if (computerAnswer.contains(userNum[i]) && computerAnswer.get(i) != userNum[i]) {
                ball++;
            }
        }
        return ball;
    }


}