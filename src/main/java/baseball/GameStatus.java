package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameStatus {
    private boolean isGameOnGoing = true;
    RestartInputException restartInputException = new RestartInputException();


    public boolean getIsGameOnGoing() {
        return isGameOnGoing;
    }

    public void setIsGameOnGoing(boolean gameOnGoing) {
        isGameOnGoing = gameOnGoing;
    }

    public void threeStrikeCase(Computer computer) {

        String reInput = Console.readLine();

        int restartInput = restartInputException.checkRestartInput(reInput);

        if (restartInput == 1) {
            setIsGameOnGoing(true);
            computer.setComputerNumber();

        }

        if (restartInput == 2) {
            setIsGameOnGoing(false);

        }
    }
}
