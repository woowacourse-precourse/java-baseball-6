package baseball;

public class GameState {
        public static final int GAME_SUCCESS_STATE = 0;
        public static final int PROGRESS_STATE = 1;
        public static final int END_STATE = 2;

        private int gameSwitch;

        public GameState(int gameSwitch) {
                this.gameSwitch = gameSwitch;
        }

        public void checkGameSuccess(int strike) {
                if (strike == 3) {
                        gameSwitch = GAME_SUCCESS_STATE;
                }
        }

        public void checkGameRetryOrEnd(int retryOrEnd) {
                if (retryOrEnd == PROGRESS_STATE) {
                        gameSwitch = PROGRESS_STATE;
                }
                if (retryOrEnd == END_STATE) {
                        gameSwitch = END_STATE;
                }
        }

        public boolean isGameSuccessState() {
                return gameSwitch == GAME_SUCCESS_STATE;
        }

        public boolean isProgressState() {
                return gameSwitch == PROGRESS_STATE;
        }

        public boolean isEndState() {
                return gameSwitch == END_STATE;
        }
}
