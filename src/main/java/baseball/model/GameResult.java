package baseball.model;

public class GameResult {

    public static class GameResultData {
        private final String gameResultMessage;
        private final boolean correctAnswered;

        private GameResultData(String gameResultMessage, boolean correctAnswered) {
            this.gameResultMessage = gameResultMessage;
            this.correctAnswered = correctAnswered;
        }

        public String getGameResultMessage() {
            return gameResultMessage;
        }

        public boolean getIsCorrectAnswered() {
            return correctAnswered;
        }
    }


    public GameResultData result(int strike, int ball) {
        String localGameResultMessage = "";
        boolean localCorrectAnswered = false;

        if (strike == 0 && ball == 0) {
            localGameResultMessage = "낫싱";
        } else if (strike == 3) {
            localGameResultMessage = "3스트라이크";
            localCorrectAnswered = true;
        } else if (strike != 0 && ball == 0) {
            localGameResultMessage = strike + "스트라이크";
        } else if (strike >= 1 && ball >= 1) {
            localGameResultMessage = ball + "볼 " + strike + "스트라이크";
        } else if (strike == 0 && ball != 0) {
            localGameResultMessage = ball + "볼";
        }
        return new GameResultData(localGameResultMessage, localCorrectAnswered);
    }
}
