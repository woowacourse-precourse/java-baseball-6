package baseball;

public class GameManager {

    private BaseBallGame baseBallGame;
    // TODO: player를 어디에 둘지 고민
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
