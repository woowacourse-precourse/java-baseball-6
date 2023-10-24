package baseball;

import java.util.List;

public class StrikeorBall {
    public Result check(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                balls++;
            }
        }
        return new Result(strikes, balls);
    }

    public static class Result {
        private int strikes;
        private int balls;

        public Result(int strikes, int balls) {
            this.strikes = strikes;
            this.balls = balls;
        }

        public int getStrikes() {
            return strikes;
        }

        public int getBalls() {
            return balls;
        }

        @Override
        public String toString() {
            if (strikes == 0 && balls == 0) {
                return "낫싱";
            }
            StringBuilder temp = new StringBuilder();
            if (balls > 0) {
                temp.append(balls).append("볼 ");
            }
            if (strikes > 0) {
                temp.append(strikes).append("스트라이크");
            }
            return temp.toString().trim();  // `.trim()`으로 끝의 공백 제거
        }
    }
}
