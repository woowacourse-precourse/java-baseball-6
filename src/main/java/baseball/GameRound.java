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
        String input = getInput();
        person.insertNumberAndValidate(input);
        BallStrikeCount ballStrikeCount = gameScore.calculateScore();
        printMessage(ballStrikeCount);
        return checkContinueGame(ballStrikeCount);
    }

    private String getInput() {
        GameMessages.printInputMessage();
        return Console.readLine();
    }

    private void printMessage(BallStrikeCount ballStrikeCount) {
        int ball = ballStrikeCount.getBallCount();
        int strike = ballStrikeCount.getStrikeCount();
        GameMessages.printStatusMessage(ball, strike);
    }

    private boolean checkContinueGame(BallStrikeCount ballStrikeCount) {
        if (isThreeStrike(ballStrikeCount)) {
            return handleUserChoice();
        }
        restartRound();
        return true;
    }

    private boolean handleUserChoice() {
        int choice = Integer.parseInt(Console.readLine());

        if (choice == GameConstants.RESTART_GAME) {
            restartGame();
            return true;
        }
        if (choice == GameConstants.END_GAME) {
            return false;
        }

        throw new IllegalArgumentException(GameConstants.NOT_A_VALID_CHOICE);
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
