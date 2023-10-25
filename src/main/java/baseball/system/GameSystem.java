package baseball.system;

import baseball.numsdata.ComputerNumberManage;
import baseball.numsdata.ResultManage;
import baseball.numsdata.UserNumberManage;
import baseball.viewer.Input;
import baseball.viewer.Output;


public class GameSystem {
    Input read = new Input();
    ComputerNumberManage randomNumber = new ComputerNumberManage();

    public void start() {
        Output show = new Output();
        show.opening();

        boolean endGame = false;

        while(!endGame){
            show.guide();
            String input = read.readNumbers();

            UserNumberManage user = new UserNumberManage(input);
            user.checkNumber();

            ResultManage result = new ResultManage();
            result.gameSetResult(user.getUserNumbers(), randomNumber.getComputerNumbers());

            show.result(result.getBall(), result.getStrike());

            if(result.getStrike() == 3){
                show.decide();
                endGame = read.gameContinue();
                if(!endGame) {
                    randomNumber = new ComputerNumberManage();
                }
            }
        }
    }
}
