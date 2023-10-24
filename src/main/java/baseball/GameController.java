package baseball;

public class GameController {

    private static GameController gameController = new GameController();

    public GameController() {
    }

    public static GameController getInstance() {
        return gameController;
    }

    public void startGame() {
        boolean choice = true; //true : 1, false : 2

        do {
            // TODO: 게임 플레이
            // TODO: 추가 플레이 여부 확인
        } while (choice);
    }
}
