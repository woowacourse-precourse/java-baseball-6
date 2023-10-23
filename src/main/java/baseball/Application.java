package baseball;

import baseball.util.exception.TerminateApplicationException;
import baseball.view.UserInputView;
import baseball.view.UserOutputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        try {
            BaseballController baseballController = new BaseballController(new UserInputView(), new UserOutputView(),
                    new BaseballService());
            baseballController.run();
        } catch (TerminateApplicationException e) {
            System.out.println(e.getMessage());
            Console.close();
        }
    }

}
