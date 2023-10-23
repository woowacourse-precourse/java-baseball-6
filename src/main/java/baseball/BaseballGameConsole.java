package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class BaseballGameConsole {
    private Game game;
    private OutputConsole outputConsole;

    public BaseballGameConsole(Game game, OutputConsole outputConsole) {
        this.game = game;
        this.outputConsole = outputConsole;
    }

    public void start(){
        outputConsole.printStartMessage();
        game.setUpForNewGame();
        while(!game.isGameFinished()){
            outputConsole.printInputForm();
            Result gameResult = game.play(Console.readLine());
            outputConsole.printResult(gameResult.getNumberOfBalls(), gameResult.getNumberOfStrikes());
            if(game.isGameFinished()){
                outputConsole.printGameFinishedMessage();
                outputConsole.printRegameMessage();
                if(playerWantsNewGame(Console.readLine())){
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
