package baseball.controller;
/*
* 게임을 관리하는 메인클래스
* */
import baseball.model.Computer;
import baseball.model.Player;
import baseball.validator.Validator;
import baseball.view.MessageView;

import java.util.List;

public class BaseballGame {
    private final Computer computer = new Computer();
    private static Player player;
    private final Validator validation = new Validator();
    private List<Integer> computerNum;


    public BaseballGame(){

    }

    public void startGame() {
        do {
            getPlayerNum();
            printCount(getNumberCompare());
        } while (!final_G());

    }

    public void getPlayerNum() {
        player = new Player(MessageView.input_M());
        player.getInputNumber();
    }

    public int[] getNumberCompare() {

        return validation.getNumberCompare(player.getInputNumber(), computer.toString());
    }

    public void printCount(int[] count) {
        ballCount(count);
        strikeCount(count);
        nothing(count);
    }

    public static void ballCount(int[] count) {
        if (count[0] != 0) {
            if(count[1] !=0) {
                MessageView.printCount(count[0]);
                MessageView.ball_M(); //ball_M()
            } else {
                MessageView.printCount(count[0]);
                MessageView.ball_M();
            }
        }
    }

    public static void strikeCount(int[] count) {
        if (count[1] != 0) {
            MessageView.printCount(count[1]);
            MessageView.strike_M();
        }
    }

    public static void nothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            MessageView.nothing_M();
        }
    }


    public boolean final_G() {
        if (validation.isThreeStrike()) {
            MessageView.final_M();
            return true;
        }
        return false;
    }
}
