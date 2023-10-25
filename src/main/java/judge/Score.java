package judge;

public class Score {
    private int ballCount = 0;
    private int strikeCount = 0;

    public Score() {
    }

    public void increaseBall() {
        ballCount++;
    }

    public void increaseStrike() {
        strikeCount++;
    }

    public void printScore() {
        StringBuilder sb = new StringBuilder();

        if (ballCount > 0) {
            sb.append(ballCount).append("볼");
        }

        if (ballCount > 0 && strikeCount > 0) {
            sb.append(" ");
        }

        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }

        sb.append("\n");

        if (strikeCount == 3) {
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        }

        System.out.print(sb);
    }

    public boolean isCorrect() {
        if (ballCount == 0 && strikeCount == 3) {
            return true;
        }

        return false;
    }
}
