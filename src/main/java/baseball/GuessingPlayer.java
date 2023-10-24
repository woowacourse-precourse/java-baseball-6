package baseball;

import baseball.balls.Balls;
import baseball.balls.PlayerBalls;
import baseball.compare.Comparator;
import baseball.output.Printer;

import java.util.List;

public class GuessingPlayer {
    Balls playerBalls;
    Printer printer = new Printer();
    public void guess(Balls answerBalls) {
        printer.printGettingPlayerBallsSentence();
        playerBalls = new PlayerBalls();
        playerBalls.createBalls();
        System.out.println(playerBalls.getBallsList());
        // TODO : 비교
        String compareResultString = new Comparator().compareBalls(answerBalls, playerBalls);
        // TODO : 비교 결과 출력
        printer.printResult(compareResultString);
        if (compareResultString.equals("3스트라이크")){
            return ;
        }
        guess(answerBalls);
    }
}
