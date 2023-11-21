package baseball.controller;

import baseball.domain.Number;
import baseball.domain.Score;
import baseball.service.GameService;
import baseball.service.PrintService;

import java.util.List;

public class BaseBall {

    private final Number num = new Number();
    private final GameService gameService = new GameService();
    private final PrintService printService = new PrintService();

    public void playBall(){
        printService.printBeforeStart();
        List<Integer> computer = gameService.generateRandomNumber(num.NUM_LENGTH);
        Score score = new Score();
        play(computer, score);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void play(List<Integer> computer, Score score) {
        while (score.getStrike() != num.NUM_LENGTH){
            List<Integer> user = gameService.getUserNumber();
            score = gameService.countOnPlay(computer,user);
            gameService.countOnPlay(computer, user);
            printService.showResult(score);
        }
    }
}
