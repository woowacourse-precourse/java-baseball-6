package baseball;


import baseball.domain.Player;
import baseball.domain.PlayerType;

public class Application {
    public static void main(String[] args)  {

        Player human = new Player(PlayerType.HUMAN);
        Player computer = new Player(PlayerType.COMPUTER);



        System.out.println("사람의 숫자");
        System.out.println(human);
        System.out.println("컴퓨터의 숫자");
        System.out.println(computer);




    }
}
