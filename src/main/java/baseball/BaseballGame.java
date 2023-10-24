package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private List<Integer> answer;

    public BaseballGame() {
        this.answer = null;
    }

    public void run() {
        generateAnswer();
    }

    private void generateAnswer() {
        answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    static public BaseballResultState match(List<Integer> a, List<Integer> b) {
        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!a.get(i).equals(b.get(j)))
                    continue;

                if (i == j)
                    strike++;
                else
                    ball++;
            }
        }

        return new BaseballResultState(ball, strike);
    }
}
