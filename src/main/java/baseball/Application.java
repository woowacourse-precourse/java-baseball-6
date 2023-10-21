package baseball;

import java.util.List;

public class Application {
    private static Computer computer;

    public static void main(String[] args) {
    }

    private static void init() {
        computer = new Computer();
        MessageStream.printStartMessage();
    }

    private static void process() {
        while (true) {
            MessageStream.printInputMessage();
            List<Integer> userInput = MessageStream.input();
            List<Integer> compareResult = computer.compareWithAnswer(userInput);
            MessageStream.printResultMessage(compareResult.get(1), compareResult.get(0));
            if (compareResult.get(1).equals(3)) {
                break;
            }
        }
    }
}
