package baseball.presentation;

public class UserOutput {

    public void printBallCount(int strike, int ball) {
        String message = "";
        if (strike > 0 && ball > 0) {
            message = ball + "볼 " + strike + "스트라이크";
        } else if (strike > 0) {
            message = strike + "스트라이크";
        } else if (ball > 0) {
            message = ball + "볼";
        } else {
            message = "낫싱";
        }
        System.out.println(message);
    }

    public void endingMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
