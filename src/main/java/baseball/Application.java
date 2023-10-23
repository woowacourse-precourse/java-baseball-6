package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        PrintMessage printMessage = new PrintMessage();
        printMessage.printGameStartMessage();

        AnswerNumberGenerator answerNumberGenerator = new AnswerNumberGenerator();
        List<Integer> answerNumberList = answerNumberGenerator.getAnswerNumberList();

        printMessage.printReadNumberMessage();
        String userInputNumber = Console.readLine();
        try {
            Validator.validateUserInputNumber(userInputNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

    }
}