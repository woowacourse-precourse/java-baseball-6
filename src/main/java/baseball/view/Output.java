package baseball.view;

public class Output {

    public void showStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void showEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void showResult(int strike, int ball) {
        String result = "낫싱";
        if (ball > 0 && strike > 0) {
            result = format("%d볼 %d스트라이크", ball, strike);
        }
        if (ball > 0 && strike == 0) {
            result = ball + "볼";
        }
        if (ball == 0 && strike > 0) {
            result = strike + "스트라이크";
        }
        System.out.println(result);
    }

    private String format(String format, Object... args) {
        return String.format(format, args);
    }
}
