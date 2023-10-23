package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    // TODO: 재시작 커맨드 상수 관리 어디서할 지 고민
    public static final String RETRY_COMMAND = "1";
    public static final String END_COMMAND = "2";

    // TODO: 사용자가 입력한 정답을 DTO 클래스로 관리하도록 리팩토링
    public String getInputAnswer() {
        String input = Console.readLine();
        InputValidator.validateInputAnswer(input);
        return input;
    }

    // TODO: 리팩토링을 해야할 것 같음
    public Boolean getIsRetry() {
        String input = Console.readLine();
        InputValidator.validateRetryInput(input);
        return input.equals(RETRY_COMMAND);
    }

    public Player() {

    }
}
