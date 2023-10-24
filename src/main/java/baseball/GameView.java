package baseball;

public class GameView {

    private static GameView gameView = new GameView();

    private GameView() {
    }

    public static GameView getInstance() {
        return gameView;
    }

    //게임 시작
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
