package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameController {
    public void run(){
        OutputView.printStartGame();
        OutputView.printInputNumber();
        List<Integer> numbers = InputView.inputNumber();
        List<Integer> computerNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);

    }
}
