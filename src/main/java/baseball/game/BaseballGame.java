package baseball.game;

import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.input.Input;
import baseball.util.GameUtil;
import baseball.validator.InputValidator;

public class BaseballGame {
    private static final int NUMBER_LENGTH = 3;

    private final GameUtil gameUtil;
    private final ComputerNumber computerNumber;
    private final PlayerNumber playerNumber;

    public BaseballGame() {
        this.gameUtil = new GameUtil();
        this.computerNumber = new ComputerNumber();
        this.playerNumber = new PlayerNumber();
    }

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
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

        System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", NUMBER_LENGTH));
    }

    private boolean checkRestartGame(){
        String inputNumber = Input.inputString("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

        InputValidator.validateCheckRestartGameInput(inputNumber);

        return inputNumber.equals("1");
    }
}
