package baseball;

import camp.nextstep.edu.missionutils.Console;
import exceptions.ThreeStrikeException;

public class GameRound {

    private GameRule rule;
    private ComputerPlayer computerPlayer;
    private UserInputHandler userInputHandler;
    private BaseBallNumber userGuess;

    public GameRound(GameRule rule) {
        this.rule = rule;
        this.computerPlayer = new ComputerPlayer(rule);
        this.userInputHandler = new UserInputHandler(rule);
        computerPlayer.decideGoalNumber();
    }

    public void playUntilCorrect() throws IllegalArgumentException {
        while (true) {
            try {
                playTurn();
            } catch (ThreeStrikeException e) {
                break;
            }
        }
    }

    private void playTurn() throws IllegalArgumentException, ThreeStrikeException {
        userGuess = userInputHandler.createUserGuess(Console.readLine());
        handleResult(computerPlayer.evaluateGuess(userGuess));
    }

    private void handleResult(ResultOfGuess result) throws ThreeStrikeException {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println("낫싱");
        } else if (result.getBall() > 0 && result.getStrike() == 0) {
            System.out.println(String.format("%d볼", result.getBall()));
        } else if (result.getBall() == 0 && result.getStrike() > 0) {
            System.out.println(String.format("%d스트라이크", result.getStrike()));
            if (result.getStrike() == rule.getGoalNumberLength()) {
                throw new ThreeStrikeException();
            }
        } else if (result.getBall() > 0 && result.getStrike() > 0) {
            System.out.println(String.format("%d볼 %d스트라이크", result.getBall(), result.getStrike()));
        }
    }
}
