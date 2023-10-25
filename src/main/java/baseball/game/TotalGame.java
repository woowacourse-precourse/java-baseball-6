package baseball.game;

public class TotalGame {

    public static void play() {
        GameView.printBeforeTotalGame();
        SetOfGame setOfGame = new SetOfGame();
        setOfGame.play();
        GameView.printAfterTotalGame();
    }
}
