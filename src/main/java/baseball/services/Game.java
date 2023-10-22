package baseball.services;

import baseball.dto.Hint;
import baseball.repository.AnswerInput;
import baseball.repository.GameNumberMaker;
import baseball.repository.GameScore;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final GameNumberMaker gameNumberMaker;
    private final AnswerInput answerInput;
    private final GameScore gameScore;
    private final Hint hint;

    private Game() {
        this.gameNumberMaker = new GameNumberMaker();
        this.answerInput = new AnswerInput();
        this.gameScore = new GameScore();
        this.hint = new Hint();
    }

    private void startGame() {
        System.out.println(Constants.START_MESSAGE);
        gameNumberMaker.generateAndSetGameNumber();
    }

    private void playGame() {
        answerInput.inputNumber();
        gameScore.checkGameScore(gameNumberMaker.getGameNumber(), answerInput.getAnswerNumber());
        System.out.println(provideHint(gameScore.getStrikeCount(), gameScore.getBallCount()));
    }

    private boolean isEndGame() {
        if (gameScore.getStrikeCount() == 3) {
            System.out.println(Constants.END_GAME);
            return true;
        }
        return false;
    }

    private String restartGame() {
        System.out.println(Constants.RESTART_GAME);
        return Console.readLine();
    }

    private String provideHint(int strikeScore, int ballScore) {

        if (strikeScore == 0 && ballScore == 0) {
            hint.setHint(Constants.NOTHING);
            return hint.getHint();
        }

        if (strikeScore == 0) {
            hint.setHint(ballScore + Constants.BALL);
            return hint.getHint();
        }

        if (ballScore == 0) {
            hint.setHint(strikeScore + Constants.STRIKE);
            return hint.getHint();
        }

        hint.setHint(ballScore + Constants.BALL + " " + strikeScore + Constants.STRIKE);

        return hint.getHint();
    }

    public static void createGame() {
        Game game = new Game();
        String resultCode = null;
        game.startGame();
        while (true) {
            game.playGame();
            if (game.isEndGame()) {
                break;
            }
        }
        resultCode = game.restartGame();
        if (resultCode.equals("2")) {
            return;
        }
        if (resultCode.equals("1")) {
            createGame();
            return;
        }
        if (!(resultCode.equals("1") && resultCode.equals("2"))) {
            InputExceptionError.throwIllegalArgumentException();
        }
    }
}
