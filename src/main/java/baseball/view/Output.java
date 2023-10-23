package baseball.view;

public class Output {

    public static final String gameStartMessage = "숫자 야구 게임을 시작합니다.";
    public static final String gameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void gameStart() {
        System.out.println(gameStartMessage);
    }

    public void gameEnd() {
        System.out.println(gameEndMessage);
    }

    public void printHint(String hint) {
        System.out.println(hint);
    }
}
