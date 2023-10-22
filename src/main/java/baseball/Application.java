package baseball;

import baseball.controller.BaseballController;
import baseball.model.ComputerModel;
import baseball.model.UserModel;
import baseball.util.exception.TerminateApplicationException;
import baseball.view.UserInputView;
import baseball.view.UserOutputView;

public class Application {

    public static void main(String[] args) {
        try {
            BaseballController baseballController = new BaseballController(new UserInputView(), new UserOutputView(),
                    new ComputerModel(), new UserModel());
            baseballController.startGame();
        } catch (TerminateApplicationException e) {
            System.out.println(e.getMessage());
        }
    }

}
