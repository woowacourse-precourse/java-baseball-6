package baseball.view;

public class outputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void displayNewGameMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void displayExitMessage() {
        System.out.println(GAME_CLEAR_MESSAGE);
    }
}
