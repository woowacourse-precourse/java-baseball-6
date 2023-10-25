package baseball.view;

import baseball.constant.errormessage.PlayerInputError;

public class ReGameInputView {

    /**
     * 입력한 문자열이 1 또는 2가 아니면 예외 발생
     *
     * @param command : 사용자가 입력한 문자열(1:재시작, 2:종료)
     */
    private void validateCorrectNumber(String command) {
        if (!command.equals("1") && !command.equals("2")) {
            throw new IllegalArgumentException(PlayerInputError.PLAYER_REGAME_WRONG_INPUT_NUMBER_MESSAGE);
        }
    }
}
