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
            display(message.start() + '\n');
            Referee referee = new Referee(generator.generateRandomAnswerList());
//            System.out.println(referee.getAnswerList());
            InputValidation inputValidation = new InputValidation();
            boolean success = false;
            while (!success) {
                display(message.requestInput());
                List<Integer> userInput = inputValidation.validateUserInput(input());
                List<Integer> result = referee.judgeUserInput(userInput);
                display(message.result(result) + '\n');
                if (result != null && result.get(0) == 0 && result.get(1) == 3) {
                    display(message.success());
                    success = true;
                }
            }
            display(message.requestRetryOrEnd() + '\n');
            int newOrEnd = newGameOrEnd(input());
            if (newOrEnd == 2) {
                gameEnd = true;
            }
        }
    }

    private void display(String message) {
        System.out.print(message);
    }

    public int newGameOrEnd(String input) {
        InputValidation inputValidation = new InputValidation();
        return inputValidation.validateNewGameRequest(input);
    }
}
