package baseball.Service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.Model.Player;
import baseball.Model.Computer;

public class GameService {

    public static void startGame(){
        setGame();
        playGame();
    }
    private static void setGame() {
        Computer.setRandomNumber();
        Player.getPlayerNumber(readLine());
    }

    private static void playGame() {

    }

    private static void endGame() {

    }
}
