package baseball;


import baseball.domain.Player;
import baseball.domain.PlayerType;

public class Application {
    public static void main(String[] args)  {

        Player human = new Player(PlayerType.HUMAN);
        Player computer = new Player(PlayerType.COMPUTER);

    }
}
