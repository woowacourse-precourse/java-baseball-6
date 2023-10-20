package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> randomNum = new ArrayList<>();

    public void playGame(){
        System.out.println("숫자 야구 게임을 시작합니다");

        do{
            initTurn();
            
        }while ();

    }

    public void initTurn(){
        randomNum.clear();
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }

}
