package baseball;

import baseball.view.InputView;

import java.util.List;

public class BaseballGame {

    public void gameStart() {
        List<Integer> numbers = InputView.readUserNumbers();
    }
}
