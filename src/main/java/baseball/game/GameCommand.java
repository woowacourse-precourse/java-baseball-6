package baseball.game;

/**
 * 게임 재시작 여부에 쓰이는 명령어를 모은 Enum 클래스이다. 1일 경우 재시작, 2일 경우 프로그램을 완전히 종료한다.
 *
 * @author Seongha Park
 */
public enum GameCommand {
    RESTART(1),
    END(2);

    private final int commandValue;

    GameCommand(int commandValue) {
        this.commandValue = commandValue;
    }

    /**
     * 현재 가지고 있는 정보가 enum 클래스의 어느 필드에 해당하는지 확인한다.
     *
     * @return 재시작일 경우 1을, 종료할 경우 2를 반환한다.
     */
    public int getCommandValue() {
        return this.commandValue;
    }
}
