package baseball;

public class GameManager {

    private BaseBallGame baseBallGame;

    public void start() {
        System.out.println(GameMessage.GAME_START);
        baseBallGame.play();
        System.out.println(GameMessage.RETRY_INPUT);
    }

    public GameManager() {
        baseBallGame = new BaseBallGame();
    }
}
