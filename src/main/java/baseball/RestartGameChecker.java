package baseball;

import camp.nextstep.edu.missionutils.Console;

public final class RestartGameChecker {
    private RestartGameChecker() {
    }

    public static String checkRestartGame() {
        MessagePrinter.printRestartGameMessage();
        String answer = Console.readLine();
        InputValidator.checkRestartResponse(answer);
        return answer;
    }
}
