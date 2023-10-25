package baseball.game;

public class SetOfGameFactory implements GameFactory {
    @Override
    public SetOfGame create() {
        return new SetOfGame(new UnitOfGameFactory());
    }
}
