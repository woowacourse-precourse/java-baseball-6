package baseball.game;

public class Game {
    private Inning inning;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        inning = new Inning();
        inning.startInning();
    }

    public boolean checkRestart() {
        return false;
    }

    public void endGame() {
    }
}
