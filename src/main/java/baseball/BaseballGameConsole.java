package baseball;

import java.util.Objects;

public class BaseballGameConsole {
    private Game game;
    private InputConsole inputConsole;
    private OutputConsole outputConsole;

    public BaseballGameConsole(Game game, InputConsole inputConsole, OutputConsole outputConsole) {
        this.game = game;
        this.inputConsole = inputConsole;
        this.outputConsole = outputConsole;
    }

    public void start(){
        outputConsole.printStartMessage();
        game.setUpForNewGame();
        while(!game.isGameFinished()){
            outputConsole.printInputForm();
            Result gameResult = game.play(inputConsole.readPrediction());
            outputConsole.printResult(gameResult.getNumberOfBalls(), gameResult.getNumberOfStrikes());
            if(game.isGameFinished()){
                outputConsole.printGameFinishedMessage();
                outputConsole.printRegameMessage();
                if(playerWantsNewGame(inputConsole.readUserIntentionForNewGame())){
                    game.setUpForNewGame();
                }
            }
        }
    }

    private boolean playerWantsNewGame(String option){
        if (Objects.equals(option, "1")){
            return true;
        }
        else if (Objects.equals(option, "2")) {
            return false;
        }
        else throw new IllegalArgumentException();
    }
}
