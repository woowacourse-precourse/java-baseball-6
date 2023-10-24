package baseball;

import java.util.List;

public class Application {
    private static Computer computer;

    public static void main(String[] args) {
        start();
        do {
            init();
            process();
        } while (restart());
    }

    private static void start() {
        OutputMessage.printStartMessage();
    }

    private static void init() {
        computer = new Computer();
    }

    private static void process() {
        int ballCount, strikeCount;
        do {
            OutputMessage.printInputMessage();

            List<Integer> compareResult = computer.compareWithAnswer(InputMessage.predictionInput());
            ballCount = compareResult.get(0);
            strikeCount = compareResult.get(1);

            OutputMessage.printResultMessage(ballCount, strikeCount);
        } while (!gameEnded(strikeCount));
    }

    private static Boolean gameEnded(int strikeCount) {
        return strikeCount == 3;
    }

    private static Boolean restart() {
        OutputMessage.restartMessage();
        return InputMessage.restartInput().equals("1");
    }
}
