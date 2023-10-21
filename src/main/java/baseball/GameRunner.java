package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRunner {
    private final GameUtils gameUtils;
    private final GameScore gameScore;
    private final Person person;

    public void playGame() {
        GameMessages.printStartMessage();
        while (true) {
            if (playRound()) {
                return;
            }
        }
    }

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
        person.insert(input);
        return gameScore.calculateScore();
    }

    private void determineMessage(BallStrikeCount ballStrikeCount) {
        int ball = ballStrikeCount.getBallCount();
        int strike = ballStrikeCount.getStrikeCount();
        GameMessages.printStatusMessage(ball, strike);
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
}
