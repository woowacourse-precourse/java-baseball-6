package baseball;

public class BaseballGame {
    private final GameSession gameSession = new GameSession();
    public void runGame(){
        do{
            gameSession.initializeGameSession();
        }while(gameSession.playGameSession());
    }
}
