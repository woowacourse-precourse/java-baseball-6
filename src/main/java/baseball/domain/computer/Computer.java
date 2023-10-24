package baseball.domain.computer;

import baseball.domain.number.Number;
import baseball.domain.player.Player;
import baseball.exception.computer.ComputerEndStateRefreshException;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.number.Number.MAX_NUMBER;
import static baseball.domain.number.Number.MIN_NUMBER;
import static baseball.domain.player.Player.*;

public class Computer {
    private List<Number> answerNumbers;
    private GameState gameState;

    private Computer(List<Number> numbers, GameState gameState) {
        this.answerNumbers = numbers;
        this.gameState = gameState;
    }

    public static Computer createComputerAnswerByRandomGenerator(GameState gameState) {
        List<Number> answerNumbers = integerToNumber(generateNumbers());
        return new Computer(answerNumbers, gameState);
    }

    public static Computer from(Player answerNumbers, GameState gameState) {
        return new Computer(answerNumbers.getNumbers(), gameState);
    }

    public static Computer init() {
        return createComputerAnswerByRandomGenerator(GameState.init());
    }

    private static ArrayList<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != BASEBALL_NUMBERS_LIMIT_SIZE) {
            numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return new ArrayList<>(numbers);
    }

    public List<Number> getAnswerNumbers() {
        return answerNumbers;
    }

    public Computer refresh() {
        if (gameState.isEndGame()) {
            throw new ComputerEndStateRefreshException();
        }
        if (gameState.isRestartGame()) {
            return init();
        }
        return this;
    }

    public boolean isFinishedGame() {
        return gameState.isEndGame();
    }

    public void changeGameState(GameState gameState) {
        this.gameState = gameState;
    }

}
