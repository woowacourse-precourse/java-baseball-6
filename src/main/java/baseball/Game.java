package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> computer = new ArrayList<>();
    private final static String BALL = "볼";
    private final static String STRIKE = "스트라이크";
    private final static String NOTHING = "낫싱";
    private final static String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public Game() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public boolean play(List<Integer> number) {
        int ballCount = Referee.countBall(computer, number);
        int strikeCount = Referee.countStrike(computer, number);

        if (ballCount > 0) {
            System.out.print(ballCount + BALL + " ");
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
