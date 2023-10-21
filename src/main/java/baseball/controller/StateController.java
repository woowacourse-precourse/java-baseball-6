package baseball.controller;

import baseball.model.ComputerModel;
import baseball.random.RandomNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class StateController {
    public static final int GAMESTATE_RESTART = 1;
    static final InputView inputview = new InputView();
    static final OutputView outputView = new OutputView();
    static final RandomNumber random = new RandomNumber();

    private ComputerModel computerModel;

    public ComputerModel gameStart() {
        this.computerModel = new ComputerModel(random.randomNumberGenerator());
        outputView.printStartMessage();
        return computerModel;
    }

    public boolean repeatPlayerExpect() {
        Map<String, Integer> scoreMap = new HashMap<String, Integer>();
        scoreMap = computerModel.scoreCalculator(inputview.inputPlayerNumber());
        return !(scoreMap.get("Strike") == 3);
    }

    public boolean gameStateChange() {
        outputView.printRestartMessage();
        return Integer.parseInt(inputview.inputRestartNumber()) == GAMESTATE_RESTART;
    }


}
