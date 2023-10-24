package baseball;

import baseball.controller.ComputerController;
import baseball.view.UserInputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> baseballNumber = ComputerController.getBaseballNumber();
        UserInputView userInputView = new UserInputView();
        List<Integer> userInputNumber = userInputView.gameStart();


    }
}
