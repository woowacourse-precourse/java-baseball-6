package baseball;

public class Application {

    private static final BaseballService baseballService = new BaseballService();

    public static void main(String[] args) {
        baseballService.playGame();
    }
}
