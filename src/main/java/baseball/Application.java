package baseball;

import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(
                new InputView(),
                new OutputView()
        );
        baseballController.start();

    }
}
