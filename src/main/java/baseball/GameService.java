package baseball;

import baseball.View.EndGameView;
import baseball.View.PlayGameView;
import baseball.View.StartGameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {

    public static void startGame()
    {
        StartGameView.printGameStart();
        do {
            // 새 게임 시작하기
            startNewGame();
        } while(
                // 게임 다시 시작할지 결정
                restartGame()
        );
    }
    public static void startNewGame(){
        List<Integer> computer = Computer.createRandomNumber();
        do {
            // 게임 START
            playGame(computer);
        } while(
                // 3 스트라이크 나올 때 까지 반복
                !Hint.isThreeBall
        );
        PlayGameView.printCorrectAnswer();
    }

    private static void playGame(List<Integer> computer) {
        PlayGameView.printInputNum();
        List<Integer> player = Player.getPlayerNumber(Console.readLine());
        Hint.compareNumber(computer, player);
    }


    private static Boolean restartGame() {
        EndGameView.printGameEnd();
        String restartOrQuit = Console.readLine();
        CheckValidNum.checkNewOrQuit(restartOrQuit);
        return restartOrQuit.equals("1");
    }

}
