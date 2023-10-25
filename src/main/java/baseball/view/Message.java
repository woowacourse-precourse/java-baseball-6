package baseball.view;

public class Message {
    public static final String ONLY_NUM = "숫자만 사용 가능합니다.";
    public static final String DUPLICATE_NUM = "같은 숫자 입력은 안됩니다.";
    public static final String INVALID_INPUT_MESSAGE = "숫자는 3자리로 입력해야합니다.";
    public static final String INVALID_GAME_NUMBER = "1(Start) 또는 2(End)로 입력해야합니다.";

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void reStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
