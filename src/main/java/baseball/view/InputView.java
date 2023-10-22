package baseball.view;

import baseball.model.PlayerNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String playerNumber(){
        OutputView.inputMessage();
        String input = Console.readLine();
        return input;
    }
}
