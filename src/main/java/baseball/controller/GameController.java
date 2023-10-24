package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.GameStatusNumber;
import baseball.model.UserNumber;
import baseball.view.EndView;
import baseball.view.MainView;
import baseball.view.StartView;
import com.sun.tools.javac.Main;

public class GameController {
    public void startGame(){
        StartView startView=new StartView();
        startView.beginMessage();
        playGame();
    }

    public void playGame(){
        ComputerNumber computerNumber=new ComputerNumber();
        UserInputHandler userInputHandler=new UserInputHandler();
        GameStatusNumber gameStatusNumber=new GameStatusNumber();
        MainView mainView = new MainView();
        EndView endView=new EndView();

        while(true){
            UserNumber userNumber=userInputHandler.getUserInputNumber();
            int strike=gameStatusNumber.countStrike(userNumber.getUserNumber(),computerNumber.getNumbers());
            int ball=gameStatusNumber.countBall(userNumber.getUserNumber(),computerNumber.getNumbers());
            int nothing = gameStatusNumber.countNothing(userNumber.getUserNumber(), computerNumber.getNumbers());

            mainView.displayResult(strike,ball,nothing);
            if(strike==3){
                endView.displayEndMessage();
                if(userInputHandler.getRestartInput()){
                    computerNumber.resetNumber();
                }
                break;
            }
        }

    }
}
