package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        List<Integer> playerNumbers = player.getPlayerNumber();

        Referee referee = new Referee();
        List<Integer> computerNumbers = referee.getComputer();
    }

}
