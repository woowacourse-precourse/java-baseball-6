package baseball.game;

public class TotalGame extends Game{
    private final SetOfGameFactory setOfGameFactory;

    public TotalGame(SetOfGameFactory setOfGameFactory) {
        this.setOfGameFactory = setOfGameFactory;
    }
    @Override
    public void play() {
        GameView.printBeforeTotalGame();
        SetOfGame setOfGame = setOfGameFactory.create();
        setOfGame.play();
        GameView.printAfterTotalGame();
    }
}
