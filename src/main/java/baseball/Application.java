package baseball;

public class Application {
    public static void main(String[] args) {
        GameModel gameModel = new GameModel(new Computer(""));
        GameView gameView = new GameView();
        boolean isGameExit = false;
        do {
            boolean isGameContinue = true;
            gameModel.setRandomNumberInComputer();
            gameView.printStartGame();
            while (isGameContinue) {
                String userNumber = gameView.getUserNumberInput();

                ResultAndView resultAndView = gameModel.compareUserAndComputerNumber(userNumber);
                gameView.printResult(resultAndView);

                isGameContinue = resultAndView.getIsContinue();
            }

            String userInput = gameView.getUserReplayInput();
            if (gameModel.isGameExit(userInput)) isGameExit = true;
        } while (!isGameExit);
    }
}
