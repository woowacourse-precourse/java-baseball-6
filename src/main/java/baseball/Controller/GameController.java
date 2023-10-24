package baseball.Controller;

import baseball.View.GameView;

public class GameController {
    GameView gameView = new GameView();

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    public void startGame() {
        gameView.printStartMessage();
//        while () {
////            String input = gameView.printInputMessage();
////            List<Integer> userInput = baseBallGame.parseUserInput(input);
////            List<Integer> ballStrikeCount = baseBallGame.checkBallCount(userInput);
//            int balls = ballStrikeCount.get(BALL);
//            int strikes = ballStrikeCount.get(STRIKE);
//
//            if (balls != 0 && strikes == 0) {
//                gameView.printBallMessage(balls);
//            } else if (balls != 0 && strikes != 0) {
//                gameView.printBallStrikeMessage(balls);
//            }
//            if (strikes != 0) {
//                gameView.printStrikeMessage(strikes);
//            }
//            if (balls == 0 && strikes == 0) {
//                gameView.printNothingMessage();
//            }
//
//            baseBallGame.gameOverCheck(strikes);
//            if (baseBallGame.isGameOver()) {
//                String inputRestart = gameView.printGameOverMessage();
//                baseBallGame.restartGame(inputRestart);
//            }
//        }
    }

}
