package baseball.controller;

import baseball.service.BaseballService;
import global.Constants;

public class BaseballController {

        BaseballService baseballService = new BaseballService();
        Constants constants = new Constants();

        public void run() {
                initGame(constants.SIZE, constants.START_NUMBER, constants.END_NUMBER);
                startGame();
                endGame();
        }

        private void initGame(int size, int start, int end) {
                baseballService.initGame(size, start, end);
        }

        private void startGame() {
                baseballService.startGame();
        }

        private void endGame() {
                baseballService.endGame();
        }


}
