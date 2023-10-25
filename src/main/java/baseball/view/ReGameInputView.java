package baseball.view;

import baseball.constant.errormessage.PlayerInputError;
import camp.nextstep.edu.missionutils.Console;

public class ReGameInputView {

    private static final String INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    /**
     * 게임 재시작 여부를 사용자로 부터 입력받고(1:재시작, 2:종료), 입력값을 검증한 뒤 문제없으면 반환
     *
     * @return : 사용자가 입력한 문자열 반환
     */
    public String inputReGameCommand() {
        System.out.println(INPUT_MESSAGE);
        String command = Console.readLine();
        validateCorrectNumber(command);
        return command;
    }

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
