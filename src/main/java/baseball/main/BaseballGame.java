package baseball.main;

import baseball.ioSystem.ComputerPoint;
import baseball.ioSystem.InputVal;
import baseball.ioSystem.PlayerPoint;
import baseball.play.Play;
import baseball.point.Total;

import java.util.Arrays;

public class BaseballGame {
    private static ComputerPoint computerPoint;
    private static PlayerPoint playerPoint;
    private static Total total;
    private static Play play;

    public BaseballGame() {
        computerPoint = new ComputerPoint();
        total = new Total();
        play = new Play();

    }

    public void start() {
        do {
            setNumberFromPlayer();
            System.out.println(getTotalFromPoint());
        }
        while(!getCheckStrikeFromPlay());
    }
    public void setNumberFromPlayer() {
        playerPoint = new PlayerPoint(InputVal.setPlayerNumber());
    }
    public String getTotalFromPoint() {
        String[] PlayerComputerPoint = playerAndComputerPoint();
        int[] point = play.getPlayBall(PlayerComputerPoint[0], PlayerComputerPoint[1]);
        return total.printPoint(point);
    }

    public boolean getCheckStrikeFromPlay() {
        return play.checkStrike();
    }

    public String[] playerAndComputerPoint() {
        return new String[] {computerPoint.getComputerPoint(), playerPoint.getPlayerPoint()};
    }
}
