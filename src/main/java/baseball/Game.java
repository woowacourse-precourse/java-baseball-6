package baseball;

public class Game {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private boolean exit = false;

    public void Game() {}

    public void gameStart() {

        while(!exit) {
            startMessage();

            return;
        }
    }

    public void startMessage() {
        System.out.println(START_MESSAGE);
    }


}
