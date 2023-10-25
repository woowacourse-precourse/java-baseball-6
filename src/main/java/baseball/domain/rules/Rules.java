package baseball.domain.rules;

public class Rules {

    // ball 카운트, strike 카운트, 성공여부 -> 성공이면 결과출력 이후 리플레이여부 묻기, 리플레이여부
    private static int GOAL = 3;

    public static int[] userScore(int[] userScore, int[] computerScore) {
        int[] score = new int[2]; // ball, strike
        score[0] = countBall(userScore,computerScore);
        score[1] = countStrike(userScore,computerScore);

        return score;
    }
    public static boolean isGameOver(int[] score) {
        if (score[1] == GOAL) return true;
        return false;
    }
    private static int countBall(int[] userScore, int[] computerScore) {
        int cnt = 0;
        for (int i = 0 ; i < GOAL ; i++) {
            for (int j = 0 ; j < GOAL ; j++) {
                if (userScore[i] == userScore[j]) cnt++;
            }
        }
        return cnt;
    }

    private static int countStrike(int[] userScore, int[] computerScore) {
        int cnt = 0;
        for (int i = 0 ; i < GOAL ; i++) {
            if (userScore[i] == computerScore[i]) cnt++;
        }
        return cnt;
    }


}
