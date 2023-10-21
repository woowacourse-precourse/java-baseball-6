package baseball.controller;

import baseball.domain.BallCounter;
import baseball.domain.Balls;
import baseball.domain.GameOption;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final DataController dataController;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.gameService = new GameService();
        this.outputView = outputView;
        this.inputView = inputView;
        this.dataController = new DataController();
    }

    public void tryOnce(List<Balls> computerBalls, BallCounter ballCounter) {
        while (!gameService.isEndGameCondition(ballCounter)) {
            inputView.showInputMessage();
            List<Balls> playerBalls = dataController.generatePlayerNumbers();
            ballCounter = gameService.judgeGames(computerBalls, playerBalls);
            outputView.showResult(ballCounter);
        }
    }
}

