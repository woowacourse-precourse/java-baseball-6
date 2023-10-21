package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.TextConstant.*;

public class GameManager {

    private GameManager() {
    }

    public static GameManager initGame() {
        return new GameManager();
    }

    public int playGame(final List<Integer> computerNumber, final List<Integer> myNumbers) {
        Discriminator discriminator = Discriminator.create(computerNumber, myNumbers);

        for (int i = START_NUMBER; i < END_NUMBER; i++) {
            boolean matchFound = false;

            for (int j = START_NUMBER; j < END_NUMBER; j++) {
                matchFound = discriminator.match(i, j);
                if (matchFound) {
                    break;
                }
            }

            if (!matchFound) {
                discriminator.nothing();
            }
        }

        discriminator.printGuessResult();

        return discriminator.getStrike();
    }

    public boolean getNextGameState() {
        String nextGameString = Console.readLine();

        int nextGameState = Integer.parseInt(nextGameString);
        validateState(nextGameState);

        return nextGameState == EXIT_GAME;
    }

    public void printNextGameNotification() {
        System.out.println(WIN_THE_GAME_MESSAGE);
        System.out.println(NEXT_GAME_OR_NOT_MESSAGE);
    }

    private void validateState(final int nextGameState) {
        if (nextGameState != RESTART_GAME && nextGameState != EXIT_GAME) {
            throw new IllegalArgumentException(NEXT_GAME_STATE_EXCEPTION);
        }
    }
}
