package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Player player = new Player(new GameManager());

        do {
            player.playGame();
        } while (player.restartGame());
    }
}