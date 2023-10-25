package baseball;

public class Application {
    public final static int NUMBER_LENGTH = 3;
    static BaseballGame baseballGame = new BaseballGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean run = true;
        while (run) {
            applicationStart();
            run = applicationRestartOrEnd();
        }
    }

    public static boolean applicationStart() {
        while (true) {
            return baseballGame.gameStart();
        }
    }

    public static boolean applicationRestartOrEnd() {
        return baseballGame.restartOrEnd();
    }
}
