package baseball;

public class GameManager {

    private BaseBallGame baseBallGame;
    private Player player;

    public void start() {
        System.out.println(GameMessage.GAME_START);
        do {
            baseBallGame.init();
            baseBallGame.play();
            System.out.println(GameMessage.RETRY_INPUT);
        } while (player.getIsRetry());
    }

    public GameManager() {
        this.player = new Player();
        this.baseBallGame = new BaseBallGame(this.player);
    }
}
