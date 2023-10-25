package baseball;

import baseball.util.BallCounter;
import baseball.util.Counter;
import baseball.util.StrikeCounter;
import java.util.List;

public class Referee {
    private final Counter ballCounter = new BallCounter();
    private final Counter strikeCounter = new StrikeCounter();

    private static final String SINGLE_BLANK = " ";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public boolean judge(List<Integer> computer, List<Integer> number) {
        int ballCount = ballCounter.count(computer, number);
        int strikeCount = strikeCounter.count(computer, number);
        return say(ballCount, strikeCount);
    }

    private boolean say(int ballCount, int strikeCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + BALL + SINGLE_BLANK);
        }
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println();
        }
        if (strikeCount > 0) {
            System.out.println(strikeCount + STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING);
        }
        if (strikeCount == 3) {
            System.out.println(END_GAME);
            return true;
        }

        return false;
    }
}
