package baseball;
import baseball.model.*;
import baseball.view.*;
import camp.nextstep.edu.missionutils.*;


public class Application {

    public static void main(String[] args) {
        gameInit();
    }
    public static void gameInit(){
        BaseballGameView gameView = new BaseballGameView();
        UserInputValidator validator = new UserInputValidator();

        do {
            GameData.UPDATE_RANDOM_NUMBERS();
            play(gameView, validator);
            userChoice(gameView);
        } while (GameData.GAME_STATUS);
    }

    public static void userChoice(BaseballGameView gameView) {
        gameView.showGameRestartMessage();
        int userChoice = Integer.parseInt(Console.readLine());
        if (userChoice == 1) {
            GameData.GAME_STATUS=true;
        } else if (userChoice == 2) {
            GameData.GAME_STATUS=false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void play(BaseballGameView gameView, UserInputValidator validator) {
        gameView.showGameStartMessage();
        while (true) {
            gameView.showUserInputPrompt();
            ScoreData scoreData = new ScoreData(GameData.RANDOM_NUMBERS, validator.validateUserInput(Console.readLine()));
            gameView.showGameResult(scoreData);

            if (scoreData.getStrike() == GameData.ENDPOINT) {
                gameView.showGameEndMessage();
                break;
            }
        }
    }
}
