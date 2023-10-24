package baseball;

public class Score {

    private final int strikeCount;
    private final int ballCount;
    private final boolean isCompleted;

    Score(int strikeCount, int ballCount, boolean isCompleted) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.isCompleted = isCompleted;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void printGameResult() {
        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }

        System.out.println();

        if (isCompleted) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
