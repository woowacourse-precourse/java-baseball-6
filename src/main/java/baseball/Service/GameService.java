package baseball.Service;

import baseball.Utils.CheckValidNumber;
import camp.nextstep.edu.missionutils.Console;

import baseball.Model.Player;
import baseball.Model.Computer;
import baseball.Model.Hint;
import baseball.View.StartGameView;
import baseball.View.PlayGameView;
import baseball.View.EndGameView;

import java.util.List;

public class GameService {

    public static void startGame()
    {
        StartGameView.printGameStart();
        do {
            startNewGame();
        } while(restartGame());
        cleanGame();
    }
    public static void startNewGame(){
        do {
            List<Integer> computer = Computer.generateRandomNumber();
            playGame(computer);
        } while(!Hint.isThreeBall);
        PlayGameView.printCorrectAnswer();
    }

    private static void playGame(List<Integer> computer) {
        PlayGameView.printInputNumber();
        List<Integer> player = Player.getPlayerNumber(Console.readLine());
        Hint.compareNumber(computer, player);
    }


    private static Boolean restartGame() {
        EndGameView.printGameEnd();
        String restartOrQuit = Console.readLine();
        CheckValidNumber.checkNewOrQuit(restartOrQuit);
        return restartOrQuit.equals("1");
    }

    private static void cleanGame() {
        Console.close();
    }
}
