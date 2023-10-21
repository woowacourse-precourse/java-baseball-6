package Controller;

import Model.Computer;
import Model.Player;
import Model.Refree;
import View.GameResult;

import java.util.ArrayList;

public class BaseBallGame {
    private static Player player;
    private static Refree refree;
    private static Computer computer;
    private static ArrayList<Integer> PlayerNumbers;
    private static int strike;
    private static int ball;
    private static boolean isNothing;

    public BaseBallGame() {
        player = new Player();
        refree = new Refree();
        computer = new Computer();
    }

    public void run() {
        do {
            System.out.println(computer.getAnswer());
            PlayerNumbers = player.InputNumbers();
            strike = 0;
            ball = 0;
            for (int i = 0; i < PlayerNumbers.size(); i++) {
                if (refree.isStrike(PlayerNumbers.get(i), computer.getAnswer(), i)) {
                    strike++;
                } else if (refree.isBall(PlayerNumbers.get(i), computer.getAnswer(), i)) {
                    ball++;
                }
            }
            //수정
            if (strike + ball == 0) {
                isNothing = true;
            } else if (strike + ball != 0) {
                isNothing = false;
            }
            GameResult.PrintResult(strike, ball, isNothing);
            if(refree.GameClear(strike)){

            }
        } while (true);
    }
}
