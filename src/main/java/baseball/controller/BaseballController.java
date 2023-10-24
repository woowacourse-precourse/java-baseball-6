package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballController {
    public void start(){
        boolean state = true;

        while (state){
            OutputView.StartMessge();
            InputView.inputNumber();
            state = false;
        }


    }
}
