package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class PracticeApplication {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computerNumbers());
    }

    // 중복되지 않은 3개의 랜덤한 숫자
    public static List<Integer> computerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    // 사용자로부터 중복되지 않은 3개의 숫자 입력받기
//    public static List<Integer> userNumbers(){
//
//    }


}


