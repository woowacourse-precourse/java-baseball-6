package baseball.view;

public class OutputView {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            String resultMessage = getBallMessage(ball) + getStrikeMessage(strike);
            System.out.println(resultMessage.trim());
        }
    }

    private String getStrikeMessage(int strike) {
        String strikeMessage = "";
        if (strike > 0) {
            strikeMessage = String.format("%s스트라이크 ", strike);
        }
        return strikeMessage;
    }

    private String getBallMessage(int ball) {
        String ballMessage = "";
        if (ball > 0) {
            ballMessage = String.format("%s볼 ", ball);
        }
        return ballMessage;
    }
}
