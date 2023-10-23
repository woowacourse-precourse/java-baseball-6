package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        boolean flag = true;

        while (flag) {
            flag = game.start();
        }
    }
}
