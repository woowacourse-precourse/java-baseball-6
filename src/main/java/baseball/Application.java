package baseball;

import baseball.io.Input;
import baseball.io.Printer;
import baseball.model.BaseballNumbers;
import baseball.model.Result;
import baseball.service.Checker;

public class Application {
    public static void main(String[] args) {
        // init
        Input input = new Input();
        Printer printer = new Printer();
        Checker checker = new Checker();

        printer.printStartMessage();

        while (true) {
            BaseballNumbers baseballNumbers = new BaseballNumbers();

            while (true) {
                printer.printGetNumbersFromPlayer();
                String inputNumbers = input.getInputNumbers();
                Result result = checker.check(inputNumbers, baseballNumbers);
                printer.printResult(result);

                if (result.getMessage().equals("3스트라이크")) {
                    printer.printStrikeMessage();
                    break;
                }
            }

            printer.printKeepPlayingMessage();

            int choice = input.getKeepPlaying();
            if (choice == 2) {
                printer.printEndMessage();
                break;
            }
        }
    }
}
