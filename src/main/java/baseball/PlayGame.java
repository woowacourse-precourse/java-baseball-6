package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    int inputNumber; //사용자가 입력하는 값
    int randomNumber; //컴퓨터가 지정한 세자리 수
    List<Integer> computer = new ArrayList<>();


    public PlayGame() {
        System.out.println("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 :");
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public String gameRestart(int type) {
        if (type == 1) {
            return "게임을 다시 시작합니다.";
        } else if (type == 2) {
            return "게임을 종료합니다.";
        } else{
            throw new IllegalArgumentException("1 또는 2 여야 합니다.");
        }
    }
}

