package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public void run(){
        printGameStart();
        List<Integer> randomNum = initRandomNum();
    }

    private void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private List<Integer> initRandomNum(){
        List<Integer> randomNumList = new ArrayList<>();
        
        while (randomNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(randomNumber)) {
                randomNumList.add(randomNumber);
            }
        }

        return randomNumList;
    }
}
