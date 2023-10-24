package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private List<Integer> answer;

    public BaseballGame() {
        this.answer = null;
    }

    public void run() {
        Controller.intro();
        do {
            playGame();
        } while (isRetry());
    }

    public void playGame() {
        generateAnswer();

        while (true) {
            boolean isGameOver = query();

            if (isGameOver) {
                break;
            }
        }

        Controller.end();
    }

    public void generateAnswer() {
        answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public boolean query() {
        ArrayList<Integer> inputValue = Controller.queryNumber();

        BaseballResultState result = match(answer, inputValue);
        System.out.println(result);
        return result.isGameOver();
    }

    public boolean isRetry() {
        return Controller.queryRetry();
    }

    static public BaseballResultState match(List<Integer> a, List<Integer> b) {
        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!a.get(i).equals(b.get(j))) {
                    continue;
                }

                if (i == j) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        return new BaseballResultState(ball, strike);
    }
}
