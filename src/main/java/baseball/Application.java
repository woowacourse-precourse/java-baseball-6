package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        baseball.MainGame game = new baseball.MainGame(new Computer(), new Validation());
        game.startGame();
    }
}
