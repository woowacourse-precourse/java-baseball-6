package baseball.controller;

import baseball.model.BallComparator;
import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.RestartNumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int STRIKE_INDEX_IN_LIST = 1;
    private static final int FINISH_GAME_STRIKE_NUMBER = 3;
    private static final String RESTART_MESSAGE = "1";
    private static ComputerNumber computerNumber;
    private static PlayerNumber playerNumber;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private BallComparator ballComparator;
    private List<Integer> computer;
    private List<Integer> player;

    public Game() {
        computerNumber = new ComputerNumber();
        playerNumber = new PlayerNumber();
        computer = new ArrayList<>();
        player = new ArrayList<>();

        outputView.printStartGame();
    }

    public void playGame() {
        computerNumber.setComputerNumber();
        computer = computerNumber.getComputerNumber();

        do {
            playerNumber.setPlayerNumber(inputView.inputPlayerGameNumber());
            player = playerNumber.getPlayerNumber();
            ballComparator = new BallComparator(computer, player);
            outputView.printCompareResult(ballComparator.getBallStrikeCount());
        } while (!finishGame());

        outputView.printFinishMessage();
    }

    public boolean askRestart() {
        String restartFinishMsg = inputView.askRestartNumber();
        RestartNumberValidator.validate(restartFinishMsg);
        return restartFinishMsg.equals(RESTART_MESSAGE);
    }

    private boolean finishGame() {
        return ballComparator.getBallStrikeCount().get(STRIKE_INDEX_IN_LIST) == FINISH_GAME_STRIKE_NUMBER;
    }
}
