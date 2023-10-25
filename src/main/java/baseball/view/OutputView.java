package baseball.view;

public class OutputView {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void inputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void refereeMessage(String message) {
        System.out.println(message);
    }

    public void gameRestartMessage() {
        System.out.println(END_GAME_MESSAGE);
        System.out.println(RE_GAME_MESSAGE);
    }
    
}
