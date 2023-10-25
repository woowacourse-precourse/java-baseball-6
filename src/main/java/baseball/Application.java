package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseballGame baseballGame = new BaseballGame();
        do {
            baseballGame.start();
            baseballGame.play();
            if (baseballGame.isFinish()) {
                break;
            }
        } while (true);
    }
}
