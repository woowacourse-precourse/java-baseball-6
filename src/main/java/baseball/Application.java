package baseball;


import baseball.domain.BaseBallGame;
import baseball.domain.Player;
import baseball.domain.PlayerType;

public class Application {
    public static void main(String[] args)  {

        BaseBallGame baseBallGame = BaseBallGame.startNewGame(new Player(PlayerType.HUMAN), new Player(PlayerType.COMPUTER));


        System.out.println(baseBallGame);



    }
}
