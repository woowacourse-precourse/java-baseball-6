package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallNumberGenerator randomNum = new BaseBallNumberGenerator();
        Player player = new Player();
        Judgement judgement = new Judgement();
        Playagain playagain = new Playagain();
        boolean again = true;

        while (again){
            List<Integer> computer = randomNum.generate();
            String result = "";
            while(!result.equals("3스트라이크")){
                result = judgement.심판(computer, player.playerNumber());
                System.out.println(result);
            }
            again = playagain.playagain();
        }
    }
}

