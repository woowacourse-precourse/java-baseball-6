package baseball.view;

public class OutputView {

    //게임 시작
    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 스트라이크 출력
    static void printStrike(int strike) {
        System.out.println(strike + "스트라이크");

        //3개의 숫자를 모두 맞힌 경우
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }

    //볼 출력
    static void printBall(int ball) {
        System.out.println(ball + "볼");
    }

    //낫싱 출력
    static void printNothing() {
        System.out.println("낫싱");
    }

    //게임 종료
    public static void end() {
        System.out.println("게임을 종료합니다.");
    }

}
