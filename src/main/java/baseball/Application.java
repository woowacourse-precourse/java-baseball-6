package baseball;


import baseball.domain.BaseBallGame;
import baseball.domain.Player;
import baseball.domain.PlayerType;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args)  {
        int replayNumber = 1;

        while(true){
            if(replayNumber == 2){
                break;
            }
            BaseBallGame.getNewGame(new Player(PlayerType.HUMAN), new Player(PlayerType.COMPUTER));
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replayNumber = Integer.parseInt(Console.readLine());
        }




    }
}
