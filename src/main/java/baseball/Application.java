package baseball;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        Game game = new Game(computer, player);
        game.run();
    }
}