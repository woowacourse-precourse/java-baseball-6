package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readUserInput() {
        String userInput = Console.readLine();
        InputValidator.validate(userInput);

        return userInput;
    }
}
