package baseball.view;

import baseball.validator.NumberCheck;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String playerNumber(){
        OutputView.inputMessage();
        String input = Console.readLine();
        return input;
    }

    public static String reStartOrOverNumber(){
        OutputView.clearMessage();
        OutputView.reStartOrOverMessage();
        String input = Console.readLine();
        NumberCheck.reStartOrOverCheck(input);
        return input;
    }
}
