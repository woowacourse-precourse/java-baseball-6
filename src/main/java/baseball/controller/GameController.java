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

    public GameController() {
        this.gameService = new GameService();
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.dataController = new DataController();
    }

    private void tryOnce(List<Balls> computerBalls, BallCounter ballCounter) {
        while (!gameService.isEndGameCondition(ballCounter)) {
            inputView.showInputMessage();
            List<Balls> playerBalls = dataController.generatePlayerNumbers();
            ballCounter = gameService.judgeGames(computerBalls, playerBalls);
            outputView.showResult(ballCounter);
        }
    }

    public void run() {
        BallCounter ballCounter = new BallCounter(0, 0); //볼 객체를 생성
        inputView.generateGameStartMessage(); //시작 메세지
        tryOnce(gameService.generateComputerNumbers(), ballCounter); //게임 시작
        outputView.showGameEndMessage(); //끝나는 메세지
        inputView.showRetryOrEndGameMessage(); //재시작 메세지
        if (retryOrExit()) run();
    }

    private boolean retryOrExit() {
        String data = readLine();
        if (data.equals(GameOption.RESTART.getOption())) {
            return true;
        }
        if (data.equals(GameOption.END.getOption())) {
            return false;
        }
        return false;
    }
}

