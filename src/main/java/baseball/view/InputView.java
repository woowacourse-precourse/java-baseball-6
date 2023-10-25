package baseball.view;

import baseball.util.RestartValidator;
import camp.nextstep.edu.missionutils.Console;

import javax.swing.plaf.PanelUI;
import javax.xml.validation.Validator;

public class InputView {

    public static String readPlayerNumbers() {
        OutputView.printStartMessage();
        OutputView.printInputNumberMessage();

        String input = Console.readLine();
        return input;
    }

}
