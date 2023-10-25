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

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }

        return false;
    }
}
