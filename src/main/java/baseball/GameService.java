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
        // 유효한 input인지 확인
        List<Integer> player = Player.getPlayerNumber(Console.readLine());
        // computer vs player 비교
        Hint.compareNumber(computer, player);
    }


    private static Boolean restartGame() {
        EndGameView.printGameEnd();
        String restartOrQuit = Console.readLine();
        // 1 or 2 외의 다른 숫자일 경우
        CheckValidNum.checkNewOrQuit(restartOrQuit);
        return restartOrQuit.equals("1");
    }

}
