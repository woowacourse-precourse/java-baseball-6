package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame baseballGame = new BaseballGame();
    }
}

class BaseballGame{
    List<Integer> computer = new ArrayList<>();
    BaseballGame(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public List<Integer> readPlayerNumber(){
        String playerNumberInString = Console.readLine();
        List<Integer> player = new ArrayList<>();
        while(player.size()<3){
            player.add(playerNumberInString.charAt(player.size())-'0');
        }
        return player;
    }
}
