package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRound {
    private final GameScore gameScore;
    private final Person person;
    private final Computer computer;

    public GameRound(Person person, Computer computer) {
        this.person = person;
        this.computer = computer;
        gameScore = new GameScore(person, computer);
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
            return handleUserChoice();
        }
        restartRound();
        return false;
    }

    private boolean handleUserChoice() {
        int choice = Integer.parseInt(Console.readLine());
        if (choice == GameConstants.RESTART_GAME) {
            restartGame();
            return false;
        }
        return choice == GameConstants.END_GAME;
    }

    private boolean isThreeStrike(BallStrikeCount ballStrikeCount) {
        return ballStrikeCount.getStrikeCount() == GameConstants.THREE_STRIKE;
    }

    public void restartRound() {
        person.clean();
    }

    public void restartGame() {
        person.clean();
        computer.clearAndInitialize();
    }
}
