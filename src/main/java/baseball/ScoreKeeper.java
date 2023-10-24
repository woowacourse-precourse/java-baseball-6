package baseball;

public class ScoreKeeper {
    private static final StringBuilder Score = new StringBuilder();
    private static int ballCount = 0;
    private static int strikeCount = 0;

    // 승리조건 확인
    public static boolean isThreeStrikes() {
        return strikeCount == 3;
    }

    // 정답 확인하기 - 볼, 스트라이크, 낫싱 출력
    public static void printScore(String answer) {
        calculateBallCount(answer);
        calculateStrikeCount(answer);

        if (ballCount == 0 && strikeCount == 0) {
            Score.append("낫싱");
        }
        System.out.println(Score);
        Score.setLength(0);
    }

    // 점수 계산하기 - 볼
    private static void calculateBallCount(String answer) {
        ballCount = 0;

        // TODO: indent 정리(depth: 3)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Defender.isBall(answer, i, j)) {
                    ballCount++;
                }
            }
        }
        if (ballCount != 0) {
            Score.append(String.format("%d볼", ballCount));
        }
    }

    // 점수 계산하기 - 스트라이크
    private static void calculateStrikeCount(String answer) {
        strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (Defender.isStrike(answer, i)) {
                strikeCount++;
            }
        }
        if (ballCount != 0) {
            Score.append(' ');
        }
        if (strikeCount != 0) {
            Score.append(String.format("%d스트라이크", strikeCount));
        }
    }
}