package baseball;

public class Application {

    private static final BaseballController controller =
            new BaseballController(new BaseballView(), new BaseballModel());

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        controller.startGame();
    }
}
