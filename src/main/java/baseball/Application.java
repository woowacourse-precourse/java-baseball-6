package baseball;

public class Application {
//    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        BaseballGameViewer viewer = new BaseballGameViewer();
        BaseballGameService service = new BaseballGameService();
        BaseballGameController controller = new BaseballGameController(viewer, service);
        controller.playGame();
    }

}
