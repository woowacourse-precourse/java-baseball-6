package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        Player player = new Player();
        Game game = new Game(computer, player);

        game.startGame(true);
    }
}
