package baseball.entity;

import baseball.View;
import baseball.impl.Computer;
import baseball.impl.Game;

public class GameImpl implements Game {
    PlayerImpl playerImpl = new PlayerImpl();
    Computer computer = new ComputerImpl();
    @Override
    public void run(){
        do{
            setGame();
        }while (playerImpl.continueInputCheck(View.ContinueMessage()));
//        View.GameEndMessage();
    }
    @Override
    public void setGame(){

        computer.MakeRandomNum();
        while(true){
            String input = View.InputMessage();
            playerImpl.gameInputCheck(input);
            boolean status = computer.CountScore(input);
            if(status){
                View.GoalMessage();
                break;
            }
        }
    }

}
