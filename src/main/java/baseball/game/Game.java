package baseball.game;

import baseball.people.Pitcher;
import baseball.people.preparation.Referee;

public class Game {
    private final Pitcher pitcher = Pitcher.enter();
    private final Referee referee = Referee.enter();

    private Game() {
    }

    /**
     * Game 객체를 생성하는 정적 팩토리 메서드
     * @return Game 객체
     */
    public static Game generate() {
        return new Game();
    }

    /**
     * 게임을 시작하는 메서드
     */
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            matchStart();
        } while (pitcher.restart());
    }

    private void matchStart() {
        int[] pitch;
        boolean strikeOut;
        do {
            pitch = pitcher.pitch();
            strikeOut = referee.strikeOut(pitch);
        } while (!strikeOut);
    }
}
