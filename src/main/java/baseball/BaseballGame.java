package baseball;

public class BaseballGame {
    private Input input;
    private OutPut output;
    private RandomGenerator randomGenerator;
    private String computerNum;
    private boolean isFinish = false;

    public BaseballGame() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.randomGenerator = new RandomGenerator();
    }

    public void start() {
        output.printStart();
        computerNum = randomGenerator.make(3);

        while (!isFinish) {
            output.printInputRequest();
            String gameInput = input.getGameInput();
        }
    }
}
