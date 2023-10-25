package baseball.domain;

public class Message {

    private Message() {
    }

    public static String init() {
        return "숫자 야구 게임을 시작합니다.";
    }

    public static String pending() {
        return "숫자를 입력해주세요 : ";
    }

    public static String correct() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public static String continueOrNot() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }

    public static String expire() {
        return "프로그램을 종료합니다.";
    }
}
