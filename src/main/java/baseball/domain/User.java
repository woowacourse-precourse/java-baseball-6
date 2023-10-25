package baseball.domain;

import baseball.ui.Input;

public class User implements Player {

    private final Input input;
//    private List<Integer> numbers;
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

    public int countNumberBalls() {
        return numbers.length();
    }

    private String generateInputNumber(int NUMBER_BALLS) {
        return this.input.scan();
    }

    public Command selectCommand() {
        String inputCommand = input.scan();

        return Command.findCommand(inputCommand);
    }
}
