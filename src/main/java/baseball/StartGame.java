package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class StartGame {
    public static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String createThreeNums(){
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computer.add(randomNumber);
        }
        StringBuilder sb = new StringBuilder();
        for (int num : computer){
            sb.append(num);
        }

        return sb.toString();
    }
}
