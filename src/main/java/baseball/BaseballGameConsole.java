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
        setUpNewGame();
        alertGameStarted();
        while(!game.isGameFinished()){
            playGameWithUserPrediction();
            if(game.isGameFinished()){
                alertGameFinishedAndAskNewGame();
                if(playerWantsNewGame(inputConsole.readUserIntentionForNewGame())){
                    setUpNewGame();
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

    private void playGameWithUserPrediction(){
        outputConsole.printInputForm();
        Result gameResult = game.play(inputConsole.readPrediction());
        outputConsole.printResult(gameResult.getNumberOfBalls(), gameResult.getNumberOfStrikes());
    }

    private void alertGameFinishedAndAskNewGame(){
        outputConsole.printGameFinishedMessage();
        outputConsole.printRegameMessage();
    }

    private void alertGameStarted(){
        outputConsole.printStartMessage();
    }

    private void setUpNewGame(){
        game.setUpForNewGame();
    }
}
