package baseball.view;

public class NumberBaseballGameOutputView {
    static final String START_GAME_MESSAGE = " 게임을 시작합니다.";

    void printStartGameMessage(String gameName) {
        System.out.println(gameName + START_GAME_MESSAGE);
    }

}
