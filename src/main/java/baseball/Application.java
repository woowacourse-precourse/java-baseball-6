package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView();
        BaseballModel baseballModel = new BaseballModel();

        BaseballController baseballController = new BaseballController(baseballView, baseballModel);
        baseballController.play();
    }
}
