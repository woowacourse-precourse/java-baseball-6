package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int gameRestart = 1;
    private int strike = 0;
    private int ball = 0;

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameRestart == 1){
            List<Integer> computer = getComputerNumber();
        }
    }

    public List<Integer> getComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
