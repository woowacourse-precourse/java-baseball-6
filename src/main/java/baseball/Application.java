package baseball;

public class Application {
    public static void main(String[] args) {
        BaseBallGameController baseBallGameController = new BaseBallGameController(new RandomBaseBallGenerator());
        baseBallGameController.play();
    }
}
