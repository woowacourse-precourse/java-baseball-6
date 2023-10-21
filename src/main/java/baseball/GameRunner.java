package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRunner {
    private final GameUtils gameUtils;
    private final GameScore gameScore;
    private final Person person;

    public GameRunner(Person person, GameUtils gameUtils, GameScore gameScore) {
        this.person = person;
        this.gameUtils = gameUtils;
        this.gameScore = gameScore;
    }

    public boolean playRound() {
        BallStrikeCount ballStrikeCount = executeRound();
        determineMessage(ballStrikeCount);
        return checkContinueGame(ballStrikeCount);
    }

    private BallStrikeCount executeRound() {
        GameMessages.printInputMessage();
        String input = Console.readLine();
        validateInput(input);
        person.insert(input);
        return gameScore.calculateScore();
    }

    private void determineMessage(BallStrikeCount ballStrikeCount) {
        int ball = ballStrikeCount.getBallCount();
        int strike = ballStrikeCount.getStrikeCount();

        if (strike > 0 && ball > 0) {
            GameMessages.printBallStrike(ball, strike);
        }

        if (0 < strike && strike < 3 && ball < 1) {
            GameMessages.printStrike(strike);
        }

        if (ball > 0 && strike < 1) {
            GameMessages.printBall(ball);
        }

        if (strike == 0 && ball == 0) {
            GameMessages.printNothing();
        }

        if (strike == 3) {
            GameMessages.printThreeStrike();
        }
    }

    private boolean checkContinueGame(BallStrikeCount ballStrikeCount) {
        if (isThreeStrike(ballStrikeCount)) {
            return handleUserChoice(ballStrikeCount);
        }

        gameUtils.restartRound(ballStrikeCount);
        return false;
    }

    private boolean handleUserChoice(BallStrikeCount ballStrikeCount) {
        int choice = Integer.parseInt(Console.readLine());
        if (choice == GameConstants.RESTART_GAME) {
            gameUtils.restartGame(ballStrikeCount);
            return false;
        }
        return choice == GameConstants.END_GAME;
    }

    private boolean isThreeStrike(BallStrikeCount ballStrikeCount) {
        return ballStrikeCount.getStrikeCount() == GameConstants.THREE_STRIKE;
    }

    private void validateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(GameConstants.NOT_NUMBER);
        }

        if (input.length() > 3) {
            throw new IllegalArgumentException(GameConstants.NOT_VALID_LENGTH);
        }
    }
}
