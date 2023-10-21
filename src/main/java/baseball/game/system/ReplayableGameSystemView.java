package baseball.game.system;

public interface ReplayableGameSystemView {

    /**
     * 게임 재시작 여부를 입력 받아 boolean으로 반환한다.
     *
     * @return 게임 재시작 입력을 받으면 true, 게임 종료 입력을 받으면 false를 반환한다.
     */
    boolean requestReplayInput();
}
