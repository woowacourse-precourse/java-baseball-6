package baseball;

public class GameController {

    private final Input input = new Input();
    private final Output output = new Output();

    public void play() {
        output.showStartMessage();
        output.showInputMessage();

        String playerNumber = input.readNumber();
        Player player = new Player(playerNumber);

        NumberGenerator numberGenerator = new NumberGenerator();
        Computer computer = new Computer(numberGenerator.createComputerNumbers());
    }
}
