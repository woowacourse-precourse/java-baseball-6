package baseball;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        BaseballController baseballController = new BaseballController(player);
        baseballController.run();
    }
}
