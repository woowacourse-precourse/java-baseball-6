package baseball;

import static baseball.Messages.*;

public class Game {
    private final String winMessage = Messages.WIN_MESSAGE;
    private Oppoent oppoent;
    private int strike;
    private int ball;

    public Game(Oppoent oppoent){
        this.oppoent = oppoent;
        this.strike = 0;
        this.ball = 0;
    }

}
