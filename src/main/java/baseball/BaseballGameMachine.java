package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameMachine {
    private Message message = new Message();
    private NumberGenerator numberGenerator = new NumberGenerator();
    private InputValidation inputValidation = new InputValidation();

    public String input() {
        return Console.readLine();
    }
    private void display(String message) {
        System.out.print(message);
    }

    public void play() {
        boolean gameEnd = false;
        while (!gameEnd) {
            display(message.start() + '\n');
            gameProcess();
            display(message.requestRetryOrEnd() + '\n');
            gameEnd = newGameOrEnd(input());
        }
    }

    public void gameProcess() {
        Referee referee = new Referee(numberGenerator.generateRandomAnswerList());
        System.out.println(referee.getAnswerList());
        boolean success = false;
        while (!success) {
            display(message.requestInput());
            List<Integer> userInput = inputValidation.validateUserInput(input());
            List<Integer> gameResult = referee.judgeUserInput(userInput);
            display(message.result(gameResult) + '\n');
            success = isSuccess(gameResult);
        }
    }

    public boolean isSuccess(List<Integer> gameResult) {
        if (gameResult == null) {
            return false;
        }
        final int ball = gameResult.get(0);
        final int strike = gameResult.get(1);
        if (ball == 0 && strike == 3) {
            return true;
        }
        return false;
    }
    public boolean newGameOrEnd(String input) {
        int userInput = inputValidation.validateNewGameRequest(input);
        if (userInput == 2) {
            return true;
        }
        return false;
    }
}
