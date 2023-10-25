package baseball;

public class Result {

    private int numberOfStrike;
    private int numberOfBall;

    public Result(int numberOfStrike, int numberOfBall) {
        this.numberOfStrike = numberOfStrike;
        this.numberOfBall = numberOfBall;
    }

    @Override
    public String toString() {
        if (numberOfStrike == 3 && numberOfBall == 0) {
            return "3스트라이크\n3개 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        if (numberOfStrike == 0 && numberOfBall == 0) {
            return "낫싱\n";
        }

        if (numberOfStrike == 0) {
            return numberOfBall + "볼\n";
        }

        if (numberOfBall == 0) {
            return numberOfStrike + "스트라이크\n";
        }

        return numberOfBall + "볼 " + numberOfStrike + "스트라이크\n";
    }

}
