package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.BaseballRules.outputOfJudgment;
import static baseball.MessageManager.getCorrectAnswerMessage;
import static baseball.MessageManager.getEndingMessage;

public class PlayBaseballGame {
    public static void play() {
        String targetNumber = ComputerRandomNumber.computerRandomNumber();
        while (true) {
            MessageManager.getInputMessage();
            String input = Console.readLine();

            InputValidator.validateInput(input);

            if (input.equalsIgnoreCase(targetNumber)) {
                getCorrectAnswerMessage();
                getEndingMessage();
                break;
            }
            System.out.println(outputOfJudgment(targetNumber, input));
        }
    }
}
