package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        boolean willBeRestarted = true;

        do {
            baseballGame.startGame();
            willBeRestarted = checkRestart();
        } while (willBeRestarted);
    }
}
