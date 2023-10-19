package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNumbers = randomNums();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computerNumbers);
    }

    public static List<Integer> randomNums(){
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
        return randomNums;
    }
}
