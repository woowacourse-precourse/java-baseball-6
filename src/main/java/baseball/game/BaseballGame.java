package baseball.game;

import baseball.domain.Computer;
import baseball.domain.Hint;
import baseball.domain.Player;
import baseball.utils.MessageConstant;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private final Hint hint;

    public BaseballGame(){
        this.hint = new Hint();
    }

    public void startGame(){
        boolean continuePlay = true;
        System.out.println(MessageConstant.START_MESSAGE);

        while(continuePlay){
            Computer computer = new Computer();
            playGame(computer);
            System.out.println(MessageConstant.IS_CONTIUNUE);
            continuePlay = isRestart();
        }
    }

    private void playGame(Computer computer){
        boolean stop = false;
        while(!stop){
            intiGame();
            System.out.print(MessageConstant.INPUT_START);
            Player player = new Player();
            stop = hint.compareNumber(computer.getComputerList(), player.getPlayer());
        }
    }

    private void intiGame(){
        hint.initStatus();
    }

    private Boolean isRestart(){
        String value = Console.readLine();
        return "1".equals(value);
    }
}
