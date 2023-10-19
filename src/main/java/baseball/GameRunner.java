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
        Count count;
        GameMessages.printInputMessage();

        person.insert(Console.readLine());

        count = gameScore.count();

        GameMessages.displayScore(count);

        if (isThreeStrike(count) && handleUserChoice()) {
            return true;
        }

        gameUtils.restartRound();
        return false;
    }

    private boolean handleUserChoice() {
        int choice = Integer.parseInt(Console.readLine());
        if (choice == RESTART_GAME) {
            gameUtils.restartGame();
            return false;
        }
        if (choice == END_GAME) {
            return true;
        }
        return false;
    }

    private boolean isThreeStrike(Count count) {
        return count.getStrikeCount() == THREE_STRIKE;
    }
}
