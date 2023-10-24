package baseball;

public class Application {
    public static void main(String[] args) {
        Game baseballgame = new Game();
        while (true) {
            if (!baseballgame.playBaseball()) {
                break;
            }
        }
    }
}
