package baseball.game;

import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.input.Input;
import baseball.util.GameUtil;
import baseball.validator.InputValidator;

import static baseball.constant.MessageConstant.*;
import static baseball.constant.SystemConstant.*;

public class BaseballGame {
    private final GameUtil gameUtil;
    private final ComputerNumber computerNumber;
    private final PlayerNumber playerNumber;

    public BaseballGame() {
        this.gameUtil = new GameUtil();
        this.computerNumber = new ComputerNumber();
        this.playerNumber = new PlayerNumber();
    }

    public void run(){
        System.out.println(GAME_START_MESSAGE);
        do{
            play();
        } while(checkRestartGame());
    }

    private void play() {
        computerNumber.setNumber();

        do {
            playerNumber.setNumber();
            gameUtil.computeCount(computerNumber.getNumber(), playerNumber.getNumber());
            System.out.println(gameUtil.showHint());
        } while(!gameUtil.checkGameOver());

        System.out.printf(GAME_OVER_MESSAGE, NUMBER_LENGTH);
    }

    private boolean checkRestartGame(){
        String inputNumber = Input.inputString(RESTART_INPUT_MESSAGE);

        InputValidator.validateCheckRestartGameInput(inputNumber);

        return inputNumber.equals(GAME_RESTART_NUMBER);
    }
}
