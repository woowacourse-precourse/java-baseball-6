package baseball;

public class GameMessages {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    //TODO [HJ]이게 여기 위치하는 것이 맞을까? 출력이랑 값 판별의 분리가 까다로워서 냅둠
    public static void displayScore(BallStrikeCount ballStrikeCount) {
        int ball = ballStrikeCount.getBallCount();
        int strike = ballStrikeCount.getStrikeCount();

        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }

        if (0 < strike && strike < 3 && ball < 1) {
            System.out.println(strike + "스트라이크");
        }

        if (ball > 0 && strike < 1) {
            System.out.println(ball + "볼");
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
