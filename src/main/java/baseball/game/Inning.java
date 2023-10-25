package baseball.game;

import baseball.player.Players;
import baseball.result.Result;

/**
 * 게임 내에서 숫자 야구 시작 ~ 숫자 야구 끝 (재시작 사이)의 객체인 Inning 클래스이다. 하나의 경기라고 보면 될 것 같다. 따라서 경기에 필요한 Players와 Result를 가지고 있다.
 *
 * @author Seongha Park
 */
public class Inning {
    private Players players;
    private Result result;

    public Inning() {
        this.players = new Players();
    }

    /**
     * 컴퓨터의 랜덤 숫자를 생성하고 사용자에게서 숫자를 입력받아 비교 작업을 진행하며 결과를 확인한다.
     * <p>
     * 3스트라이크일 경우, "3스트라이크"를 출력한 후, 이닝을 마무리한다.
     */
    public void startInning() {
        players.createComputerNumber();

        do {
            players.createUserNumber();

            result = players.compareNumbers();

            result.checkResult();
        } while (!result.isWin());

        result.printWin();
    }
}
