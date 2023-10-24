package baseball.game;

import baseball.people.Pitcher;
import baseball.people.preparation.Referee;

public class Game {
    private final Pitcher pitcher = Pitcher.enter();
    private final Referee referee = Referee.enter();

    private Game() {
    }

    /** Game 객체를 생성하는 정적 팩토리 메서드. */
    public static Game generate() {
        return new Game();
    }

    /**
    *게임을 시작하는 메서드.
    *적절한 입력을 받는 것으로 진행할 수 있고,
    *잘못된 입력이 들어오면 애플리케이션이 종료된다.
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
