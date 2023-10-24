package baseball;

import java.util.List;

public interface ComputerServer {

    /**
     * make random computer numbers
     */
    void startGame();

    /**
     * ask end the game or start new game
     * @return true = new game, false = end game
     */
    boolean endGame();

    /**
     * print how many balls are correct
     * @param numbers: user input numbers
     * @return correct or not
     */
    boolean hint(List<Integer> numbers);
}
