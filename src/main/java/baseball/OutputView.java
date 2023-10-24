package baseball;

public class OutputView {

    private Integer strikeCount;
    private Integer ballCount;
    private boolean isNothing;

    public OutputView(Integer strikeCount, Integer ballCount, boolean isNothing) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.isNothing = isNothing;
    }

    public void printResult() {
        if (isNothing()) {
            System.out.println("낫싱");
        } else if (existStrikeAndBall()) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (existOnlyStrike()) {
            System.out.println(strikeCount + "스트라이크");
            if (strikeCount==3) {
                System.out.println("3개의 숫자를 모두 맞히쳤습니다! 게임 종료");
            }
        } else if (existOnlyBall()) {
            System.out.println(ballCount + "볼");
        }
    }

    private boolean existOnlyBall() {
        return strikeCount==0 && ballCount > 0;
    }

    private boolean existOnlyStrike() {
        return strikeCount > 0 && ballCount==0;
    }

    private boolean existStrikeAndBall() {
        return strikeCount > 0 && ballCount > 0;
    }

    private boolean isNothing() {
        return isNothing;
    }

}
