package baseball.controller;

import baseball.domain.Hitter;
import baseball.domain.Pitcher;
import baseball.domain.Result;
import baseball.view.BaseBallView;


public class BaseBallGame {

    private static final String CONTINUE_GAME_SIG = "1";
    private static final String END_GAME_SIG = "2";
    private static final String WRONG_INPUT_ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private static final BaseBallView baseBallView  = BaseBallView.create();

    private static Pitcher pitcher;
    private static Hitter hitter;
    private static Result result;

    private BaseBallGame() {
    }

    public static void run() {
        baseBallView.startGameView();
        startGame();
    }

    private static void startGame() {
        pitcher = Pitcher.create();

        playBall();

        checkContinueGame();
    }

    private static void playBall() {
        startOneBattle();

        baseBallView.finishView();
    }

    private static void startOneBattle() {
        changeHitter();
        result = pitcher.throwBalls(hitter);

        baseBallView.resultGameView(result.toString());

        checkIsFinish();
    }

    private static void changeHitter() {
        String numberString = baseBallView.numbersInputView();
        hitter = Hitter.create(numberString);
    }

    private static void checkContinueGame() {
        String continueInputString = baseBallView.continueInputView();
        if (isContinueGame(continueInputString)) {
            startGame();
        }
    }

    private static void checkIsFinish() {
        if (result.isContinue()) {
            playBall();
        }
    }

    private static boolean isContinueGame(String continueInputString) {
        if (continueInputString.equals(CONTINUE_GAME_SIG)) {
            return true;
        }
        if (continueInputString.equals(END_GAME_SIG)) {
            return false;
        }

        throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
    }

}
