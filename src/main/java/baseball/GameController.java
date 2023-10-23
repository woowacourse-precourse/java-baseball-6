package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController {
    private final Computer computer;
    private final Input input;
    private final Output output;
    private List<Integer> targetNumbers;

    public GameController() {
        this.computer = new Computer();
        this.input = new Input();
        this.output = new Output();
        this.targetNumbers = new ArrayList<>();
    }

    public void play() {
        boolean isGameOver = false;

        output.gameStart();
        targetNumbers = computer.generateRandomNumbers();
        while (!isGameOver) {
            List<Integer> userGuess = input.getUserGuess();
            Map<String, Integer> result = computer.compareNumbers(targetNumbers, userGuess);
            output.hint(result);
        }
    }
}
