package baseball;

public class BaseballGame {
    private final GameHandler gameHandler = new GameHandler();
    public void runGame(){
        do{
            gameHandler.initializeGameSession();
        }while(gameHandler.playGameSession());
    }
}
