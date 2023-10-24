package baseball.Check;

public class Score {
    public static void result(int str, int ball) {
        if (str == 3) {
            System.out.println(str + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (str > 0 && ball == 0) {
            System.out.println(str + "스트라이크");
        } else if (str == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else if (str > 0 && ball > 0) {
            System.out.println(ball + "볼 " + str + "스트라이크");
        } else if (str == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }
}
