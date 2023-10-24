package baseball;

import static baseball.GameNumber.*;
import static console.Printer.printRestartOrExit;
import static console.Printer.printInput;
import static console.Printer.printQuit;
import static console.Printer.printResult;
import static console.Printer.printStart;
import static console.Validator.validateInput;
import static console.Validator.validateOption;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        String answer = makeRandomNumber();
        printStart();
        while (true) {
            boolean isCorrect = false;
            printInput();
            String input = Console.readLine();
            validateInput(input);
            Result result = Result.calculate(input, answer);
            printResult(result);
            if (result.isAllCorrect()) {
                printQuit(NUMBER_LIMIT);
                isCorrect = true;
            }
            if (isCorrect) {
                printRestartOrExit(RESTART, EXIT);
                String option = Console.readLine();
                validateOption(option);
                if (Integer.parseInt(option) == EXIT) break;
                else answer = makeRandomNumber();
            }
        }
    }

    static String makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LIMIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream().map(Object::toString).collect(Collectors.joining());
    }
}
