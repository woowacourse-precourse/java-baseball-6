package baseball;

public class Application {
    public static void main(String[] args) {

//        BaseballGame baseballGame = new BaseballGame();
//        baseballGame.play();

        BaseballController baseballController = new BaseballController(new BaseballView(), new BaseballModel());
        baseballController.play();
    }
}
