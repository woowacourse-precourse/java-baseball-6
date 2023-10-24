package baseball;

import java.util.List;

import static baseball.Utils.*;

public class Game {
//    private final String winMessage = Messages.WIN_MESSAGE;
    private final Oppoent oppoent;
    private int strike;
    private int ball;

    public Game(Oppoent oppoent){
        this.oppoent = oppoent;
        this.strike = 0;
        this.ball = 0;
    }

    public void initialiser() {
        oppoent.initialiser();
        strike = 0;
        ball = 0;
    }

    public void gamePlay() {
        List<Integer> userNumbers;
        while (strike < DESIGNED_NUM) {

        }
    }
}
