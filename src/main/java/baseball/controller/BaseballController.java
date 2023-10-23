package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();
    public static final ComputerNumber computerNumber = new ComputerNumber();
    public static final PlayerNumber playerNumber = new PlayerNumber();
    private List<Integer> coumputerNumberList;
    private List<Integer> playerNumberList;
    public void startGame() {
        outputView.printStart();
        playGame();
    }

    public void playGame() {
        coumputerNumberList = computerNumber.generateNumber();
        playerNumberList = playerNumber.playerNumberToList(inputView.inputPlayerNumber());
    }
}
