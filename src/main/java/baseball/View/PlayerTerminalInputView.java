package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class PlayerTerminalInputView {

    public String input() {
        String queryString = Console.readLine();
        return queryString;
    }
}
