package baseball.factory;

import baseball.domain.Game;

public class GameFactoryImpl implements GameFactory{
    private Game game;

    @Override
    public Game getGameInstance() {
        if ( game == null )
            game = new Game();
        return game;
    }
}
