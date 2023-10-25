package baseball.system;

import baseball.numsdata.ComputerNumberManage;
import baseball.numsdata.ResultManage;
import baseball.numsdata.UserNumberManage;
import baseball.viewer.Input;
import baseball.viewer.Output;


public class GameSystem {
    Input read = new Input();
    Output show = new Output();
    ComputerNumberManage randomNumber = new ComputerNumberManage();
    UserNumberManage user = new UserNumberManage();
    ResultManage result = new ResultManage();

    private boolean endGame = false;

    public void start() {
        show.opening();
        while(!endGame){
            show.guide();

            String input = read.readNumbers();
            user.checkNumber(input);

            result.gameSetResult(user.getUserNumbers(), randomNumber.getComputerNumbers());
            show.result(result.getBall(), result.getStrike());

            if(result.getStrike() == 3){
                show.decide();
                endGame = read.gameContinue();
                if(!endGame) {
                    randomNumber.makeRandomNums();
                }
            }
        }
    }
}
