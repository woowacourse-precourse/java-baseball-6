package baseball;

import java.util.Map;

public class BaseballGame {
    private Input input;
    private OutPut output;
    private RandomGenerator randomGenerator;
    private Comparator comparator;
    private String computerNum;
    private boolean isFinish = false;

    public BaseballGame() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.comparator = new Comparator();
        this.randomGenerator = new DiffNumberRandomGenerator();
    }

    public BaseballGame(Input input, OutPut outPut, Comparator comparator, RandomGenerator randomGenerator) {
        this.input = input;
        this.output = outPut;
        this.comparator = comparator;
        this.randomGenerator = randomGenerator;
    }

    public void start() {
        output.printStart();
        computerNum = randomGenerator.make(3);

        while (!isFinish) {
            output.printInputRequest();
            String userNum = input.getGameInput();

            Map<String, Integer> result = comparator.getResult(computerNum, userNum);
            checkIsFinish(result);
            output.printScore(result);

            if (isFinish) {
                output.printFinish();
                if (isRestart()) {
                    restartGame();
                }
            }
        }
    }

    private void restartGame() {
        isFinish = false;
        computerNum = randomGenerator.make(3);
    }

    private boolean isRestart() {
        output.askRestart();
        String restartInput = input.getRestartInput();

        if (restartInput.equals("1")) {
            return true;
        }

        return false;
    }

    private void checkIsFinish(Map<String, Integer> result) {
        if (result.get("strike") == 3) {
            this.isFinish = true;
        }
    }
}
