package baseball;
import baseball.balls.Balls;
import baseball.balls.RandomBalls;
import baseball.output.Printer;
public class Baseball {
    Printer printer = new Printer();
    public void play() {
        printer.printGameStartingSentence();
        Balls answerBalls;
        answerBalls = new RandomBalls();
        answerBalls.createBalls();
        new GuessingPlayer().guess(answerBalls);
        printer.printGameEndingSentence();
        printer.printAskForNewGame();
        new GameContinueSelector().gameContinueSelect();
    }
}
