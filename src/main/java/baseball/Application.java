package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Output output = new Output();
        GameState gameState = new GameState(output.gameStart());
        while (gameState.gameSwitch != GameState.END_STATE) {
            NumberController numberController = new NumberController();
            GameScore gameScore = new GameScore(numberController.suggestedNumberConverter(input.numberSuggestion()),
                    numberController.randomComputerNumberGenerator());
            output.drawOutResult(gameScore.getBall(), gameScore.getStrike());
            if (gameScore.getStrike() == 3) {
                output.gameEnd();
                gameState.gameSwitch = input.retryOrEnd();
            }
        }
    }
}
