package baseball;


import baseball.domain.BaseBallGame;
import baseball.domain.Player;
import baseball.domain.PlayerType;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args)  {
        String replyNumber = "1";

        while(!replyNumber.equals("2")){
            BaseBallGame.getNewGame(new Player(PlayerType.HUMAN), new Player(PlayerType.COMPUTER));
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replyNumber = Console.readLine();
        }






    }
}
