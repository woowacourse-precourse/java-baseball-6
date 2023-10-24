package baseball;

public class Message {
    public static void startmessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void numberrequest() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void scoremessage(int strike, int ball) {
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    public static void winmessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void retryquestion() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
