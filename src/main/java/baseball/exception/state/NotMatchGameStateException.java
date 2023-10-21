package baseball.exception.state;

public class NotMatchGameStateException extends IllegalArgumentException {

    public NotMatchGameStateException(final int stateNumber) {
        super(stateNumber + "은 잘못된 입력입니다. 게임을 재시작하려면 1, 종료하려면 2를 입력해주세요");
    }
}
