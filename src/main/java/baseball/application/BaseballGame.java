package baseball.application;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;


public class BaseballGame {
    public void play() {
        List<Integer> answers = NumberGenerator.generateAnswer();
        boolean isAnswer = false;

        while(!isAnswer) {
            Player player = new Player(InputView.inputNumber());
            Referee referee = new Referee();
            BallCount ballCount = referee.call(answers, player.getPickNumbers());
            ResultView resultView = new ResultView();
            resultView.printResult(ballCount);
            isAnswer = ballCount.isAllStrike();
        }
    }
}
