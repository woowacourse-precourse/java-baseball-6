package baseball.game;

import baseball.player.Computer;
import baseball.util.GamePrinter;
import baseball.player.Person;

/**
 * 게임을 실행하는 클래스입니다.
 */
public class GameRunner {
    private final GameRound gameRound;

    /**
     * GameRunner 객체를 생성함과 동시에 GameRound객체를 생성합니다.
     *
     * @param person 플레이어 객체
     * @param computer 컴퓨터 객체
     */
    public GameRunner(Person person, Computer computer) {
        this.gameRound = new GameRound(person, computer);
    }

    /**
     * 게임을 시작하고 매 라운드를 진행합니다.
     */
    public void playGame() {
        GamePrinter.startMessage();
        while (true) {
            if (!gameRound.playRound()) {
                return;
            }
        }
    }
}
