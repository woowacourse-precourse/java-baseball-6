package baseball.view;

public class Output {
    public static void initGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void ballCount(int ball) {
        System.out.print(ball + "볼");
    }

    public static void strikeCount(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void nothing() {
        System.out.println("낫싱");
    }

    public static void threeStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
