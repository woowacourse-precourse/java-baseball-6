package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager game = new GameManager(new Computer());
        game.gameStart();
    }
}
