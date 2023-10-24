package baseball;

public class Exception {

    public void Exception_PlayerNumberLength(String inputNumber) {
        // 플레이어 숫자 자리수가 초과되었을 때 예외 송출
        if (inputNumber.length() != Constant.gameNumberLength) {
            throw new IllegalArgumentException("입력된 숫자의 자릿수가 올바르지 않습니다.");
        }
    }

    public void Exception_ReplayNumber(String inputNumber) {
        // 게임 재시작값 입력 예외 송출
        if (!inputNumber.equals(Constant.wantToReplay) && !inputNumber.equals(Constant.gameExit)) {
            throw new IllegalArgumentException("입력된 값이 올바르지 않습니다.");
        }
    }
}