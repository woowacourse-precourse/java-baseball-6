package baseball.view;

public class OutputView {
    public void printBallAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
    }

    public String printBallAndStrike2(int ball, int strike){
        String result = "";
        result += (ball > 0) ? ball + "볼" : "";
        result += (strike > 0) ? strike + "스트라이크" : "";
        return result.isEmpty() ? "낫싱" : result;
    }
}
