package baseball.controller;

import baseball.domain.Number;
import baseball.domain.Score;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseBall {

    private final Number number = new Number();
    private final GameService gameService = new GameService();

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void playBall(){
        while (true){
            outputView.printBeforeStart();
            List<Integer> computer = gameService.generateRandomNumber(number.NUM_LENGTH);
            System.out.println("computer = " + computer);
            Score score = new Score();
            play(computer, score);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            boolean continueGame = inputView.inputAfterFinish();
            if (!continueGame) {
                break;
            }
        }
    }

    private void play(List<Integer> computer, Score score) {
        while (score.getStrike() != number.NUM_LENGTH){
            List<Integer> user = gameService.getValidUserNumber();
            score = gameService.countOnPlay(computer,user);
            gameService.countOnPlay(computer, user);
            outputView.showResult(score);
        }
    }
}
