package baseball;

import java.util.List;

public class Application {
    private static Computer computer;

    public static void main(String[] args) {
        boolean isGameContinuing = true;
        start();
        while (isGameContinuing) {
            init();
            process();
            isGameContinuing = restart();
        }
    }

    private static void start() {
        MessageStream.printStartMessage();
    }

    private static void init() {
        computer = new Computer();
    }

    private static void process() {
        while (true) {
            MessageStream.printInputMessage();
            List<Integer> userInput = MessageStream.predictionInput();
            List<Integer> compareResult = computer.compareWithAnswer(userInput);
            MessageStream.printResultMessage(compareResult.get(0), compareResult.get(1));
            if (compareResult.get(1).equals(3)) {
                break;
            }
        }
    }

    private static Boolean restart() {
        MessageStream.restartMessage();
        String isRestarting = MessageStream.restartInput();
        return isRestarting.equals("1");
    }
}
