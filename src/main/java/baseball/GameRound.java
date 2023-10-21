package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRound {
    private final GameScore gameScore;
    private final Person person;
    private final Computer computer;

    public GameRound(Person person, Computer computer, GameScore gameScore) {
        this.person = person;
        this.computer = computer;
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
        person.insertNumberAndValidate(input);
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
        restartRound(ballStrikeCount);
        return false;
    }

    private boolean handleUserChoice(BallStrikeCount ballStrikeCount) {
        int choice = Integer.parseInt(Console.readLine());
        if (choice == GameConstants.RESTART_GAME) {
            restartGame(ballStrikeCount);
            return false;
        }
        return choice == GameConstants.END_GAME;
    }

    private boolean isThreeStrike(BallStrikeCount ballStrikeCount) {
        return ballStrikeCount.getStrikeCount() == GameConstants.THREE_STRIKE;
    }

    public void restartRound(BallStrikeCount ballStrikeCount) {
        ballStrikeCount.clean();
        person.clean();
    }

    public void restartGame(BallStrikeCount ballStrikeCount) {
        ballStrikeCount.clean();
        person.clean();
        computer.clearAndInitialize();
    }
}
