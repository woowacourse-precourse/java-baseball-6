package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Init {
    public static List<Integer> answer = new ArrayList<>();

    public static void initialize() {
        // 시작 상태 ON
        Application.onProcess = true;
        // 시작 문구 출력
        System.out.println(Text.startingText);
        // 서로 다른 숫자로 구성된 3자리 숫자 랜덤 생성
        answer = generateNumber();
    }

    static List<Integer> generateNumber() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < Variables.answerLength){
            int randomInt = Randoms.pickNumberInRange
                    (Variables.randomRangeStart, Variables.randomRangeEnd);
            if (!number.contains(randomInt)) {
                number.add(randomInt);
            }
        }

        return number;
    }
}

