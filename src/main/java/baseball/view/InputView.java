package baseball.view;

import baseball.util.RestartValidator;
import camp.nextstep.edu.missionutils.Console;

import javax.swing.plaf.PanelUI;
import javax.xml.validation.Validator;

public class InputView {

    public static String readPlayerNumbers() {
        OutputView.printInputNumberMessage();

        String input = Console.readLine();
        return input;
    }

    public static String readRestartCommand(){
        OutputView.printRestartMessage();

        String input = Console.readLine();
        RestartValidator.validateRestartNumber(input);
        return input;
    }

}
