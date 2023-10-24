package baseball.model;

public class GameResult {

    public GameResultData result(int strike, int ball) {
        GameResultType resultType = GameResultType.findType(strike, ball);
        String formattedMessage = formatMessage(resultType, strike, ball);
        return new GameResultData(formattedMessage, resultType.isCorrectAnswer());
    }

    private String formatMessage(GameResultType type, int strike, int ball) {
        return String.format(type.getGameResultMessage(), ball, strike);
    }

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
}
