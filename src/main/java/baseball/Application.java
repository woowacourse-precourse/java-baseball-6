package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame model = new BaseballGame();
        BaseballView view = new BaseballView();
        BaseballController controller = new BaseballController(model, view);

        controller.playGame();
    }
}