package baseball;

public class BaseballGame {
    private final UserValidateStadium userValidateStadium;
    private final ComputerOrganizer computerOrganizer;
    private boolean isEnd = false;
    private int strikeCount = 0;

    public BaseballGame() {
        userValidateStadium = new UserValidateStadium();
        computerOrganizer = new ComputerOrganizer();
    }

    public void startBaseballGame() {
        userValidateStadium.displayMessage(Constant.Game_Start);

        while (!isEnd) {
            computerOrganizer.createRandomNumbers();
            playGame();

            boolean shouldExit = userValidateStadium.getLeaveGameType(isEnd);

            if (shouldExit) {
                isEnd = true;
                handleExit();
            } else {
                isEnd = false;
                strikeCount = 0;
                handleRestart();
            }
        }
    }

    private void playGame() {
        boolean isCorrectNumber = false;

        while (!isCorrectNumber && !isEnd) {
            BaseballManager userBaseballNumbers = getUserInput();
            Umpire umpire = computerOrganizer.makeUserInputUmpire(userBaseballNumbers);
            isCorrectNumber = umpire.isCorrectNumber();

            if (isCorrectNumber) {
                strikeCount++;
                if (strikeCount == 3) {
                    userValidateStadium.displayMessage(strikeCount + " " + Constant.Status_Strike);
                    userValidateStadium.displayMessage(Constant.Game_Over);
                    userValidateStadium.displayMessage(Constant.Restart_or_Exit);
                } else {
                    userValidateStadium.displayMessage(Constant.Restart_or_Exit);
                }
            } else {
                userValidateStadium.displayMessage(umpire.getBaseballNumberCount());
            }
        }
    }

    private BaseballManager getUserInput() {
        String userInput = userValidateStadium.getUserInput(Constant.Input_Number);
        return new BaseballManager(userInput);
    }

    private void handleRestart() {
        userValidateStadium.displayMessage(strikeCount + " " + Constant.Status_Strike);
        userValidateStadium.displayMessage(Constant.Game_Over);
        userValidateStadium.displayMessage(Constant.Restart_or_Exit);
    }

    private void handleExit() {
        userValidateStadium.displayMessage(Constant.Exit_Game);
    }

}
