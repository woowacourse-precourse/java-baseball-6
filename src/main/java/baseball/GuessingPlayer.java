package baseball;
import baseball.balls.Balls;
import baseball.balls.PlayerBalls;
import baseball.compare.Comparator;
import baseball.output.Printer;
public class GuessingPlayer {
    Balls playerBalls;
    Printer printer = new Printer();
    public void guess(Balls answerBalls) {
        printer.printGettingPlayerBallsSentence();
        playerBalls = new PlayerBalls();
        playerBalls.createBalls();
        String compareResultString = new Comparator().compareBalls(answerBalls, playerBalls);
        printer.printResult(compareResultString);
        if (compareResultString.equals("3스트라이크")){
            return ;
        }
        guess(answerBalls);
    }
}
