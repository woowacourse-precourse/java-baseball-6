package baseball;

public class Application {
//    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        BaseballGameViewer viewer = new BaseballGameViewer();
        BaseballGameController controller = new BaseballGameController(viewer);
        controller.playGame();
    }

}
