package baseball;

import baseball.balls.Balls;
import baseball.balls.PlayerBalls;
import baseball.balls.RandomBalls;
import baseball.compare.Comparator;
import baseball.output.Printer;

public class Baseball {
    Printer printer = new Printer();
    public void play() {
        printer.printGameStartingSentence();
        Balls answerBalls;
        // TODO : 정답 공 번호들 생성
        answerBalls = new RandomBalls();
        answerBalls.createBalls();
        System.out.println(answerBalls.getBallsList());
        new GuessingPlayer().guess(answerBalls);
        printer.printGameEndingSentence();
        printer.printAskForNewGame();
        new GameContinueSelector().gameContinueSelect();

    }
}
