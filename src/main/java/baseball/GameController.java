package baseball;

import java.util.List;

public class GameController {

    private static GameController gameController = new GameController();
    private GameView view = GameView.getInstance();
    private GameModel model = GameModel.getInstance();

    public GameController() {
    }

    public static GameController getInstance() {
        return gameController;
    }

    public void startGame() {
        view.startGame();
        boolean choice = true; //true : 1, false : 2

        do {
            List<Integer> computer = model.generateComputerNums();
            // TODO: 게임 플레이
            // TODO: 추가 플레이 여부 확인
        } while (choice);
    }
}
