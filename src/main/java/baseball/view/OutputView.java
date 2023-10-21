package baseball.view;

public class OutputView {
    int strikeCount;
    int ballCount;

    public OutputView(int strikeCount, int ballCount){
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }
    public void outputResult() {
        if (strikeCount > 0 && ballCount > 0) {
            printStrikeAndBall(strikeCount, ballCount);
        }
        if (strikeCount > 0 && ballCount == 0) {
            printStrike(strikeCount);
        }
        if (strikeCount == 0 && ballCount > 0) {
            printBall(ballCount);
        }
        if (strikeCount == 0 && ballCount == 0) {
            printNothing();
        }
    }

    private void printStrike(int strikeCount){
        System.out.println(strikeCount + "스트라이크");
    }

    private void printBall(int ballCount){
        System.out.println(ballCount + "볼");
    }

    private void printStrikeAndBall(int strikeCount, int ballCount){
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    private void printNothing(){
        System.out.println("낫싱");
    }

}
