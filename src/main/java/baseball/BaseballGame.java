package baseball;

public class BaseballGame {
    private Input input;
    private OutPut output;
    private boolean isFinish = false;

    public BaseballGame() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
    }

    public void start() {
        output.printStart();

        while (!isFinish) {
            output.printInputRequest();
            String gameInput = input.getGameInput();
        }
    }
}
