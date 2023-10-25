package baseball;

public class Game {
    private Computer computer;
    private Player player;
    private GameManager gameManager;

    public Game() {
        computer = new Computer();
        player = new Player();
        gameManager = new GameManager(computer, player);
    }
    public void start() {
        gameManager.startGame();
    }
}
