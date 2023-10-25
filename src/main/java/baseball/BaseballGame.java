package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    final static public int ANSWER_LENGTH = 3;
    final static public int ANSWER_MIN_VALUE = 1;
    final static public int ANSWER_MAX_VALUE = 9;

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

        while (answer.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(ANSWER_MIN_VALUE, ANSWER_MAX_VALUE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public boolean query() {
        ArrayList<Integer> inputValue = Controller.queryNumber();

        BaseballResultState result = BaseballResultState.match(answer, inputValue);
        Controller.showResult(result);
        return result.isGameOver();
    }

    public boolean isRetry() {
        return Controller.queryRetry();
    }
}
