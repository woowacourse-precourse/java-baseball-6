package racingcar.controller;

import java.util.List;
import racingcar.ui.InputView;

public class RacingGameController {
    public void start() {
        List<String> nameList = InputView.inputCarNames();
    }
}
