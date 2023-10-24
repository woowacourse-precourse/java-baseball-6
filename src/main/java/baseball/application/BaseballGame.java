package baseball.application;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;


public class BaseballGame {
    boolean gameContinue = false;

    public void play() {
        InputView inputView = new InputView();
        inputView.printStartGameMessage();
        List<Integer> answers = NumberGenerator.generateAnswer();

        while(!gameContinue) {
            Player player = new Player(inputView.inputNumber());
            Referee referee = new Referee();
            BallCount ballCount = referee.call(answers, player.getPickNumbers());
            ResultView resultView = new ResultView();
            resultView.printResult(ballCount);
            GameHost gameHost = new GameHost();
            gameContinue = gameHost.checkGameContinue(ballCount.isAllStrike());
        }
    }
}
