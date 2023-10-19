package baseball;

import static baseball.GameConstants.*;

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
        GameMessages.displayScore(ballStrikeCount);
        return checkContinueGame(ballStrikeCount);
    }

    private BallStrikeCount executeRound() {
        GameMessages.printInputMessage();
        String input = Console.readLine();
        validateInput(input);
        person.insert(input);
        return gameScore.calculateScore();
    }

    private void validateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }

        if (input.length() > 3) {
            throw new IllegalArgumentException(NOT_VALID_LENGTH);
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
        if (choice == RESTART_GAME) {
            gameUtils.restartGame(ballStrikeCount);
            return false;
        }
        if (choice == END_GAME) {
            return true;
        }
        return false;
    }

    private boolean isThreeStrike(BallStrikeCount ballStrikeCount) {
        return ballStrikeCount.getStrikeCount() == THREE_STRIKE;
    }
}
