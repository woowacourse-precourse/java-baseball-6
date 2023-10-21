package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameMachine {
    public Message message = new Message();
    public String input() {
        return Console.readLine();
    }

    public void play() {
        boolean gameEnd = false;
        while (!gameEnd) {
            NumberGenerator generator = new NumberGenerator();
            startMessage();
            Referee referee = new Referee(generator.generateRandomAnswerList());
            System.out.println(referee.getAnswerList());
            InputValidation inputValidation = new InputValidation();
            boolean success = false;
            while (!success) {
                System.out.print(message.requestInput());
                List<Integer> userInput = inputValidation.validateUserInput(input());
                List<Integer> result = referee.judgeUserInput(userInput);
                System.out.println(message.result(result));
                if (result != null && result.get(0) == 0 && result.get(1) == 3) {
                    System.out.println(message.success());
                    success = true;
                }
            }
            System.out.println(message.requestRetryOrEnd());

        }
    }

    public void startMessage() {
        System.out.println(message.start());
    }

    public int newGameOrEnd(String input) {

    }
//    public void
}
