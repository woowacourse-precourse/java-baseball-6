package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.BaseballRules.outputOfJudgment;
import static baseball.MessageManager.getCorrectAnswerMessage;
import static baseball.MessageManager.getEndingMessage;

public class PlayBaseballGame {
    public static void play() {
        String targetNumber = ComputerRandomNumber.computerRandomNumber();
//        boolean play = true;
        while (true) {
            MessageManager.getInputMessage();
            String input = Console.readLine();
            InputValidator.validateInput(input);
//            try {
//                InputValidator.validateInput(input);
//            } catch (IllegalArgumentException e) {
//               System.err.println(e.getMessage());
//               break;
//            }
            if (input.equalsIgnoreCase(targetNumber)) {
                getCorrectAnswerMessage();
                getEndingMessage();
//                play = false;
                break;
            }
            System.out.println(outputOfJudgment(targetNumber, input));
        }
//        return play;
    }
}
