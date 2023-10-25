package baseball.game;

import baseball.people.Pitcher;
import baseball.people.preparation.Referee;
import java.util.List;

public class Game {
    private final Pitcher pitcher = Pitcher.enter();
    private final Referee referee = Referee.enter();

    private Game() {
    }

    /**
     * Game 객체를 생성하는 정적 팩토리 메서드
     *
     * @return Game 객체
     */
    public static Game generate() {
        return new Game();
    }

    /**
     * 게임을 시작하는 메서드
     */
    public void start() {
        do {
            matchStart();
        } while (pitcher.restart());
    }

    private void matchStart() {
        referee.playBall();
        List<Integer> pitch;
        boolean strikeOut;
        do {
            pitch = pitcher.pitch();
            strikeOut = referee.strikeOut(pitch);
        } while (!strikeOut);
    }
}
