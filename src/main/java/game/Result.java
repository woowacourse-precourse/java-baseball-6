package game;

public class Result {
    private int strikes;
    private int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isComplete() {
        return strikes == NumberBaseballGame.getNumberLength();
    }

    public void print() {
        StringBuilder resultMessage = new StringBuilder();

        // 볼 먼저 체크
        if (balls > 0) {
            resultMessage.append(balls).append("볼");
        }
        // 스트라이크 체크
        if (strikes > 0) {
            if (resultMessage.length() > 0) {
                resultMessage.append(" ");
            }
            resultMessage.append(strikes).append("스트라이크");
        }

        // 둘 다 없을 경우 "Nothing" 출력
        if (strikes == 0 && balls == 0) {
            resultMessage.append("낫싱");
        }

        System.out.println(resultMessage);

    }
}
