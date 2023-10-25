package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        baseball.Controller.BaseballGameController baseballController = new baseball.Controller.BaseballGameController();
        baseballController.startBaseballGame();
    }
}