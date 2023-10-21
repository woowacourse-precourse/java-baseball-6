package baseball.view;

public class Message {
    public static void StartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void InputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void EndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void RestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void PlayMessage(String result) {
        System.out.println(result);
    }

}
