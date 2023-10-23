package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameMachine {
    private Message message = new Message();
    private NumberGenerator numberGenerator = new NumberGenerator();
    private InputValidation inputValidation = new InputValidation();
    private Referee referee = new Referee();

    public String playerInput() {
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
            gameEnd = isGameEnd(playerInput());
        }
        display(message.gameEnd() + '\n');
    }

    public void gameProcess() {
        referee.setAnswerList(numberGenerator.generateRandomAnswerList());
        System.out.println(referee.getAnswerList());
        boolean success = false;
        while (!success) {
            display(message.requestInput());

            String playerInput = playerInput();
            inputValidation.validatePlayerInput(playerInput);
            List<Integer> userAnswer = inputValidation.convertUserInput(playerInput);
            List<Integer> gameResult = referee.judgeUserInput(userAnswer);

            display(message.result(gameResult) + '\n');
            success = isSuccess(gameResult);
        }
    }

    public boolean isSuccess(List<Integer> gameResult) {
        final int ball = gameResult.get(0);
        final int strike = gameResult.get(1);
        if (ball == 0 && strike == 3) {
            return true;
        }
        return false;
    }

    public boolean isGameEnd(String playerInput) {
        final int userInput = inputValidation.validateGameEndRequestInput(playerInput);
        if (userInput == 2) {
            return true;
        }
        return false;
    }
}
