package model.system;

public class GameController implements GameSystem {

    public GameController() {
    }

    @Override
    public void execute() {
        GameStarter gameStarter = new GameStarter();
        GameTerminator gameTerminator = new GameTerminator();

        gameStarter.execute();
        gameTerminator.execute();
    }

}
