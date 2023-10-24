package baseball.view;

public class Output {
    public static void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void strikeMessage() {
        System.out.println("스트라이크");
    }

    public static void ballMessage() {
        System.out.print("볼");
    }

    public static void nothingMessage() {
        System.out.println("낫싱");
    }

    public static void gameSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void num(int num) {
        System.out.print(num);
    }

    public static void space() {
        System.out.print(" ");
    }

    public static void line() {
        System.out.print("\n");
    }
}
