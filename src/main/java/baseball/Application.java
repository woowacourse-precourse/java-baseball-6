package baseball;

import baseball.computer.Computer;
import baseball.player.Player;
import baseball.refree.Refree;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Computer computer = new Computer();
            Player player = new Player();
            Refree refree = new Refree();

            List<Integer> computerNum = computer.generate();
            List<Integer> playerNum = player.enter();

            String result = refree.count(computerNum, playerNum);
            System.out.println(computerNum);
            System.out.println(playerNum);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 - " + e.getMessage());
        }
    }
}
