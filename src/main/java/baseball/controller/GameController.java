package baseball.controller;

import baseball.model.Game;
import baseball.model.ResultRecord;
import baseball.view.Input;
import baseball.view.Output;
import baseball.view.Speak;

import java.util.List;

public class GameController {
    Input inputController = new Input();
    Output outputController = new Output();

    public void gameStart(){
        System.out.println(Speak.startGameSpeak);
        while(true){
            Game game = new Game();
            ResultRecord gameResult = new ResultRecord();
            List<Integer> userInput = inputController.inputNumber();
            game.result(userInput,gameResult);
            outputController.resultPrint(gameResult.getBallCount(), gameResult.getStrikeCount());

            while(!game.getSuccess()){
                userInput = inputController.inputNumber();
                game.result(userInput,gameResult);
                outputController.resultPrint(gameResult.getBallCount(), gameResult.getStrikeCount());
            }

            if(!inputController.startOrEnd()){
                break;
            }
        }
    }

}
