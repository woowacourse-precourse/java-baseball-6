package baseball;

public class BaseballGame {
    private ConsoleInput input;
    private boolean isFinish = false;

    public BaseballGame() {
        this.input = new ConsoleInput();
    }

    public void start() {
        while (!isFinish) {
            String gameInput = input.getGameInput();
            System.out.println(gameInput);
        }
    }
}
