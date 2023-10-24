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

        BaseballResultState result = BaseballResultState.match(answer, inputValue);
        System.out.println(result);
        return result.isGameOver();
    }

    public boolean isRetry() {
        return Controller.queryRetry();
    }


}
