package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.core.Core;
import baseball.models.Score;
import baseball.utils.Utils;
import java.util.List;

public class Baseball {
    final int OUT = 3;

    Core core = new Core();

    public void run() {
        List<Integer> computer = Utils.generateRandomNumber(3);
        Score score = new Score();
        while (score.getStrikes() != OUT) {
            List<Integer> user = getUserNumber();
            playBall(computer, user, score);
            showResult(score);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        Utils.validateStringThreeDifferentDigits(userInput);
        return Utils.stringToIntegerList(userInput);
    }

    public void playBall(List<Integer> computer, List<Integer> user, Score score) {
        int strikes = core.countStrike(computer, user);
        int balls = core.countBall(computer, user);
        score.setScore(strikes, balls);
    }

    public void showResult(Score score) {
        core.printGameResult(score.getStrikes(), score.getBalls());
    }
}