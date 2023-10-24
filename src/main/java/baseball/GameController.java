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
        boolean choice;

        do {
            List<Integer> computer = model.generateComputerNums();
            play(computer);
            choice = view.replay();
        } while (choice);
    }

    public void play(List<Integer> computer) {
        List<Integer> user;
        List<Integer> res;
        boolean allMatch = false;
        do {
            user = view.userInput();
            res = model.compareNums(computer, user);
            view.displayResult(res);
            if (res.get(1) == 3) {
                allMatch = true;
            }
        } while (!allMatch);
    }
}
