package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class NumberBaseballGameMachine {
    private Message message = new Message();
    private NumberGenerator numberGenerator = new NumberGenerator();
    private InputValidation inputValidation = new InputValidation();
    private Referee referee = new Referee();
    private final int END_GAME = 2;

    public String getInputLine() {
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
            display(message.requestNewGameOrEnd() + '\n');

            gameEnd = isGameEnd(getInputLine());
        }
        display(message.gameEnd() + '\n');
    }

    public void gameProcess() {
        boolean success = false;

        referee.setAnswer(numberGenerator.generateRandomAnswer());
        while (!success) {
            display(message.requestPlayerGuess());
            String playerInput = getInputLine();
            inputValidation.validatePlayerInput(playerInput);
            List<Integer> playerAnswer = inputValidation.convertPlayerInput(playerInput);
            List<Integer> gameResult = referee.judgePlayerInput(playerAnswer);
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
        final int convertedValue = inputValidation.validateGameEndRequestInput(playerInput);

        if (convertedValue == END_GAME) {
            return true;
        }

        return false;
    }
}
