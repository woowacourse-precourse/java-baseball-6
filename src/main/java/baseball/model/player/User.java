package baseball.model.player;

import baseball.constants.Command;
import baseball.ui.Input;

public class User implements Player {

    private final Input input;
    private String numbers;

    public String getNumbers() {
        return numbers;
    }

    public User(Input input) {
        this.input = input;
    }

    @Override
    public void generatePlayerNumber(final int NUMBER_BALLS) {
        this.numbers = generateInputNumber(NUMBER_BALLS);
    }

    private String generateInputNumber(int NUMBER_BALLS) {
        return input.scan();
    }

    public Command selectCommand() {
        return Command.findByCommand(input.scan());
    }
}
