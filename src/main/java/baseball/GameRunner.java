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
        GameMessages.printInputMessage();

        person.insert(Console.readLine());

        BallStrikeCount ballStrikeCount = gameScore.calculateScore();

        GameMessages.displayScore(ballStrikeCount);

        if (isThreeStrike(ballStrikeCount) && handleUserChoice(ballStrikeCount)) {
            return true;
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
