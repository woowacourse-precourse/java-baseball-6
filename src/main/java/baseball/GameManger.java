package baseball;

public class GameManger {
    public GameManger() {
    }

    public void startGame() {
        boolean isProgress = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isProgress) {
            Game game = new Game();
            isProgress = game.start();
        }
    }

}
