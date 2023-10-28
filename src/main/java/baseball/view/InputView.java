package baseball.view;

import static baseball.enums.Message.GAME_END_PROMPT;
import static baseball.util.PrintUtils.printMessage;
import static baseball.util.ValidationUtils.validateInput;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.enums.GameOverSignal;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getInputValue() {
        String inputValue = readLine();

        validateInput(inputValue);
        return inputValue;
    }

    public boolean askIfContinue() {
        printMessage(GAME_END_PROMPT);

        return GameOverSignal.isNotFinished(readLine());
    }

    public void close() {
        Console.close();
    }
}
