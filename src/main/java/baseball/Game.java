package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> answerList = new ArrayList<>();

    private void init() {
        answerList.clear();
        while (answerList.size() < 3) {
            // 랜덤한 1부터 9의 서로 다른 3자리의 수 생성
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }
    }

    public void run() {
        boolean isRun = true;
        while(isRun) {
            // 게임 초기화
            init();

            playingGame();

            isRun = checkPlayAgain();
        }
    }

    private void playingGame() {
        while(true) {

        }
    }

    private void checkAnswer() {

    }

    private boolean checkPlayAgain() {
        return false;
    }
}
