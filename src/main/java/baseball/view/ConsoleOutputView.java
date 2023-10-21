package baseball.view;

public class ConsoleOutputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_NUMBER = "숫자를 입력해주세요 : ";
    public static final String MORE_GAME = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.";
    private static final String GOOD_GAME = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void gameStart() {
        System.out.println(GAME_START);
    }

    public void requestNumber() {
        System.out.print(REQUEST_NUMBER);
    }

    public void writeMessage(String message) {
        System.out.println(message);
    }

    public void moreGame(final int moreNumber, final int endNumber) {
        System.out.printf(MORE_GAME, moreNumber, endNumber);
    }

    public void goodGame(final int targetSize) {
        System.out.println(targetSize + GOOD_GAME);
    }
}
