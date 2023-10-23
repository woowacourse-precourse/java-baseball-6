package baseball;

public class Application {

    private static final BaseballService baseballService = new BaseballService();

    public static void main(String[] args) {
        while (true) {
            baseballService.playGame();
            if (!baseballService.isRestart()) {
                break;
            }
        }
    }
}
