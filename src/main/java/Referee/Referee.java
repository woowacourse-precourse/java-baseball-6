package Referee;

import Player.Computer;
import Player.Player;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Referee {
    Computer computer = new Computer();
    Player player = new Player();

    public int[] calculateStrikeAndBall(List<Integer> computerBaseballNumber, List<Integer> playerBaseballNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computerBaseballNumber.size(); i++) {
            if (computerBaseballNumber.get(i).equals(playerBaseballNumber.get(i))) {
                strike++;
                continue;
            }

            if (computerBaseballNumber.contains(playerBaseballNumber.get(i))) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }

    public void playBall() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            player.inputPlayerNumber();
            int[] score = calculateStrikeAndBall(player.getPlayerBaseballNumber(), computer.getComputerBaseballNumber());
            int strike = score[0];
            int ball = score[1];

            if (hasStrikeAndBall(strike, ball)) {
                System.out.println(ball + "볼" + " " + strike + "스트라이크");
            }
            if (hasStrikeButNoBall(strike, ball)) {
                System.out.println(strike + "스트라이크");
            }
            if (hasBallButNoStrike(strike, ball)) {
                System.out.println(ball + "볼");
            }
            if (noStrikeAndBall(strike, ball)) {
                System.out.println("낫싱");
            }
        } while (!isThreeStrike());

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        continueOrFinish();
    }

    public void continueOrFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(Console.readLine().equals("1")) {
            playBall();
        }
    }

    private boolean isThreeStrike() {
        return player.getPlayerBaseballNumber().equals(computer.getComputerBaseballNumber());
    }

    private boolean hasStrikeAndBall(int strike, int ball) {
        return strike > 0 && ball > 0;
    }

    private boolean hasStrikeButNoBall(int strike, int ball) {
        return strike > 0 && ball == 0;
    }

    private boolean hasBallButNoStrike(int strike, int ball) {
        return ball > 0 && strike == 0;
    }

    private boolean noStrikeAndBall(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

}
