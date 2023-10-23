package baseball;

import baseball.core.Core;
import baseball.model.Score;
import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    final int OUT = 3;
    Core T = new Core();

    public void run() {
        List<Integer> computerNumber = Utils.generateComputerRandomNumber(3);
        Score score = new Score();
        while (score.getStrike() != OUT) {
            List<Integer> userNumber = getUserNum();
            play(computerNumber, userNumber, score);
            showGameResult(score);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public List<Integer> getUserNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        Utils.validateStringNaturalNumberLengthDuplicate(userNumber);
        return Utils.stringToNumberList(userNumber);
    }

    public void play(List<Integer> computerNumber, List<Integer> userNumber, Score score) {
        int strike = T.countStrike(computerNumber, userNumber);
        int ball = T.countBall(computerNumber, userNumber);
        score.setScore(strike, ball);
    }

    public void showGameResult(Score score) {
        T.printGameResult(score.getStrike(), score.getBall());
    }
}
