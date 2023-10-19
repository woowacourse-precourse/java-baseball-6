package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    // TODO: 프로그램 구현
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다."); // 게임 시작 문구


        List<Integer> computer = new ArrayList<>(); // 랜덤 숫자 생성
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }


    }
}

