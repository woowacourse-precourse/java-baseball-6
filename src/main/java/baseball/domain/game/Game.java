package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.input.Input;
import baseball.domain.input.error.InputError;
import baseball.domain.input.error.InputException;
import baseball.domain.output.Output;

import java.util.List;

public class Game {
    private final Input input;
    private final Computer computer;
    private final Output output;

    public Game(Input input, Computer computer, Output output) {
        this.input = input;
        this.computer = computer;
        this.output = output;
    }
}
