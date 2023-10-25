package baseball.presentation;

public class UserOutput {

    public boolean outputMessage(int strike, int ball) {
        String message = "";
        if (strike > 0 && ball > 0) {
            message = strike + "스트라이크 " + ball + "볼";
        } else if (strike > 0) {
            message = strike + "스트라이크";
        } else if (ball > 0) {
            message = ball + "볼";
        } else {
            message = "낫싱";
        }
        System.out.println(message);

        return strike == 3;
    }
}
