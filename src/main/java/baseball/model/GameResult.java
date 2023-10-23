package baseball.model;

public class GameResult {

    public static class RealResult {
        private String message;
        private boolean restart;

        private RealResult(String message, boolean restart) {
            this.message = message;
            this.restart = restart;
        }

        public String getGameResultMessage() {
            return message;
        }

        public boolean getRestart() {
            return restart;
        }
    }

    public RealResult result(int strike, int ball) {
        String localMessage = "";
        boolean localRestart = false;

        if (strike == 0 && ball == 0) {
            localMessage = "낫싱";
        } else if (strike == 3) {
            localMessage = "3스트라이크";
            localRestart = true;
        } else if (strike != 0 && ball == 0) {
            localMessage = strike + "스트라이크";
        } else if (strike >= 1 && ball >= 1) {
            localMessage = ball + "볼 " + strike + "스트라이크";
        } else if (strike == 0 && ball != 0) {
            localMessage = ball + "볼";
        }
        return new RealResult(localMessage, localRestart);
    }
}
