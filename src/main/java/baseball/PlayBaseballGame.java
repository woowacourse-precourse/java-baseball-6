package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayBaseballGame {
    public static boolean play() {
        String targetNumber = ComputerRandomNumber.computerRandomNumber();
        boolean play = true;
        while (true) {
            MessageManager.getInputMessage();
            String input = Console.readLine();

            try {
                InputValidator.validateInput(input);
            } catch (IllegalArgumentException e) {

               System.err.println(e.getMessage());

               break;
            }
            if (input.equalsIgnoreCase(targetNumber)) {
                play = false;
                break;
            }
            System.out.println(targetNumber);
        }
        return play;
    }
}
