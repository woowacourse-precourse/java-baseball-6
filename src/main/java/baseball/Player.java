package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    // TODO: 재시작 커맨드 상수 관리 어디서할 지 고민
    public static final String RETRY_COMMAND = "1";
    public static final String END_COMMAND = "2";

    public GameNumber getInputGameNumber() {
        return GameNumber.makeGameNumberByInput(Console.readLine());
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
