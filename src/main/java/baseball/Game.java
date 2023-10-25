package baseball;

import static baseball.GameState.BALL;
import static baseball.GameState.END_GAME;
import static baseball.GameState.NOTHING;
import static baseball.GameState.STRIKE;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> computer = new ArrayList<>();

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
            System.out.print(ballCount + BALL.getMessage() + " ");
        }
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println();
        }
        if (strikeCount > 0) {
            System.out.println(strikeCount + STRIKE.getMessage());
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING.getMessage());
        }
        if (strikeCount == 3) {
            System.out.println(END_GAME.getMessage());
            return true;
        }
        return false;
    }
}
