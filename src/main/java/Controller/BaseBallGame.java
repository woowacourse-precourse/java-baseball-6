package Controller;

import Constant.ExceptionHandling;
import Model.Computer;
import Model.Player;
import Model.Refree;
import View.GameInterface;

import java.util.ArrayList;

public class BaseBallGame {
    private static Player player;
    private static Refree refree;
    private static Computer computer;
    private static ArrayList<Integer> PlayerNumbers;
    private static int strike;
    private static int ball;
    private static boolean isNothing;
    private static boolean restarFlag = true;

    public BaseBallGame() {
        player = new Player();
        refree = new Refree();
        computer = new Computer();
        GameInterface.PrintGameStart();
    }

    public void run() {
        computer.CreateAnswer();
        do {
            PlayerNumbers = player.GuessNumbers(GameInterface.InputNumbers());
            ExceptionHandling.ExceptionLength(PlayerNumbers);
            ExceptionHandling.ExceptionDuplication(PlayerNumbers);
            ExceptionHandling.ExceptionIsZero(PlayerNumbers);
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
            GameInterface.PrintResult(strike, ball, isNothing);
            if (GameInterface.GameClear(strike)) {
                if (GameInterface.GameRestart()) {
                    this.run();
                }
                break;
            }
        } while (true);
    }

    public void start() {
        while (restarFlag) {
            this.run();
        }
    }
}
