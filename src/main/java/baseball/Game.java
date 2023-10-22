package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final GameNumberMaker gameNumberMaker;
    private final AnswerInput answerInput;
    private final GameScore gameScore;
    private final Hint hint;

    public Game() {
        this.gameNumberMaker = new GameNumberMaker();
        this.answerInput = new AnswerInput();
        this.gameScore = new GameScore();
        this.hint = new Hint();
    }

    public void startGame() {
        System.out.println(Contants.START_MESSAGE);
        gameNumberMaker.generateAndSetGameNumber();
    }

    public void playGame() {
        answerInput.inputNumber();
        gameScore.checkStrike(gameNumberMaker.getGameNumber(), answerInput.getAnswerNumber());
        gameScore.checkBall(gameNumberMaker.getGameNumber(), answerInput.getAnswerNumber());
        System.out.println(provideHint(gameScore.getStrikeCount(), gameScore.getBallCount()));
    }

    public boolean isEndGame() {
        if (gameScore.getStrikeCount() == 3) {
            System.out.println(Contants.END_GAME);
            return true;
        }
        return false;
    }

    public String restartGame() {
        System.out.println(Contants.RESTART_GAME);
        return Console.readLine();
    }

    public String provideHint(int strikeScore, int ballScore) {

        if (strikeScore == 0 && ballScore == 0) {
            hint.setHint(Contants.NOTHING);
            return hint.getHint();
        }

        if (strikeScore == 0) {
            hint.setHint(ballScore + Contants.BALL);
            return hint.getHint();
        }

        if (ballScore == 0) {
            hint.setHint(strikeScore + Contants.STRIKE);
            return hint.getHint();
        }

        hint.setHint(ballScore + Contants.BALL + " " + strikeScore + Contants.STRIKE);

        return hint.getHint();
    }
}
