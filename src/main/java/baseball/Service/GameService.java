package baseball.Service;

import camp.nextstep.edu.missionutils.Console;

import baseball.Model.Player;
import baseball.Model.Computer;
import baseball.View.StartGameView;
import baseball.View.PlayGameView;
import baseball.View.EndGameView;

public class GameService {

    public static void startGame(){
        StartGameView.printGameStart();
        Computer.setRandomNumber();
        playGame();
    }

    private static void playGame() {
        PlayGameView.printInputNumber();
        Player.getPlayerNumber(Console.readLine());
    }

    private static void endGame() {

    }
}
