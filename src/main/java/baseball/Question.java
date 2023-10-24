package baseball;


import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

// 랜덤 값 생성
public class Question {
    public static List<Integer> question() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }
}