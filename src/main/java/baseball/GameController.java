package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final Computer computer;
    private final Output output;
    private List<Integer> targetNumbers;

    public GameController() {
        this.computer = new Computer();
        this.output = new Output();
        this.targetNumbers = new ArrayList<>();
    }

    public void play() {
        output.gameStart();
        targetNumbers = computer.generateRandomNumbers();
    }
}
