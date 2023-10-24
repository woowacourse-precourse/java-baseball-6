package baseball;

public class GameStartView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void run() {
        this.printStartGameMessage();
    }

    public void printStartGameMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
}
