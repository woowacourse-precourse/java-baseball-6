package baseball.controller;

import baseball.domain.BallCounter;
import baseball.domain.Balls;
import baseball.service.BallsGenerator;
import baseball.service.GameService;
import baseball.service.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final DataController dataController;
    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.dataController = new DataController();
    }

    public void playGame(List<Balls> computerBalls, BallCounter ballCounter) {
        while (!gameService.isEndGameCondition(ballCounter)) {
            inputView.showInputMessage();
            List<Balls> playerBalls = dataController.generatePlayerNumbers();
            ballCounter = gameService.judgeGames(computerBalls, playerBalls);
            outputView.showResult(ballCounter);
        }
    }

    public void run() {
        BallCounter ballCounter = new BallCounter(0, 0);
        inputView.generateGameStartMessage();
        List<Balls> computerBalls = gameService.generateComputerNumbers();
        playGame(computerBalls, ballCounter);
        outputView.showGameEndMessage();
        inputView.showRetryOrEndGameMessage();
        retryOrExit();
    }

    public void retryOrExit() {
        String data = readLine();
        if (data.equals("1")) {
            run();
        }
        if (data.equals("0")) {
            System.exit(0);
        }
    }
}

