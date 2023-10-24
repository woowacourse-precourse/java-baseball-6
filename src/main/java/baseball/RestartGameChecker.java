package baseball;

import camp.nextstep.edu.missionutils.Console;

public class RestartGameChecker {
    public static String checkRestartGame() {
        MessagePrinter.printRestartGameMessage();
        String answer = Console.readLine();
        InputValidator.checkRestartResponse(answer);
        return answer;
    }
}
