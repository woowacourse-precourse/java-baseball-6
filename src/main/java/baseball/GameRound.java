package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRound {

    private GameRule rule;
    private ComputerPlayer computerPlayer;
    private UserInputHandler userInputHandler;
    private BaseBallNumber userGuess;

    public GameRound(GameRule rule) {
        this.rule = rule;
        this.computerPlayer = new ComputerPlayer(rule);
        this.userInputHandler = new UserInputHandler(rule);
    }

    public void play() throws IllegalArgumentException {
        userGuess = userInputHandler.createUserGuess(Console.readLine());
    }

}
