package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Output output = new Output();
        GameState gameState = new GameState(output.gameStart());
        NumberController numberController = new NumberController();
        /*List<Integer> computer = new ArrayList<>(numberController.randomComputerNumberGenerator());
        while (gameState.gameSwitch != GameState.END_STATE) {
            GameScore gameScore = new GameScore(numberController.suggestedNumberConverter(input.numberSuggestion()),
                    computer);
            output.drawOutResult(gameScore.getBall(), gameScore.getStrike());
            if (gameScore.getStrike() == 3) {
                output.gameEnd();
                gameState.gameSwitch = input.retryOrEnd();
                computer = numberController.randomComputerNumberGenerator();
            }
        }*/
        /*while(gameState.gameSwitch != GameState.END_STATE){
            List<Integer> computer = new ArrayList<>(numberController.randomComputerNumberGenerator());
            while(true){
                GameScore gameScore = new GameScore(numberController.suggestedNumberConverter(input.numberSuggestion()),
                        computer);
                output.drawOutResult(gameScore.getBall(), gameScore.getStrike());
                if(gameScore.getStrike() == 3){
                    break;
                }
            }
            output.gameEnd();
            gameState.gameSwitch = input.retryOrEnd();
        }*/
        while (gameState.gameSwitch != GameState.END_STATE) {
            List<Integer> computer = new ArrayList<>(numberController.randomComputerNumberGenerator());
            do {
                GameScore gameScore = new GameScore(numberController.suggestedNumberConverter(input.numberSuggestion()),
                        computer);
                output.drawOutResult(gameScore.getBall(), gameScore.getStrike());
                gameState.checkGameSucceeded(gameScore.getStrike());
            } while (gameState.gameSwitch != GameState.GAME_SUCCEED_STATE);
            output.gameEnd();
            gameState.gameSwitch = input.retryOrEnd();
        }
    }
}
