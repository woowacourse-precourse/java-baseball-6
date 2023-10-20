package baseball.Controller;

import baseball.domain.Score;
import baseball.service.GameService;
import baseball.service.PrintService;

import java.util.List;

public class PlayBall {
    GameService gameService = new GameService();
    PrintService printService = new PrintService();

    public void play(){
        printService.printBeforeStart();
        List<Integer> computer = gameService.generateRandomNumber(3);
        Score score = new Score();
        while (score.getStrike() != 3){
            List<Integer> user = gameService.getUserNumber();
            int same = gameService.sameCount(computer, user);
            gameService.countOnPlay(computer, user, score, same );
            printService.showResult(score);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        printService.printAfterFinish();
    }
}
