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
        // 서로 다른 숫자 랜덤 생성
        answer = generateNumber();
//        System.out.println(answer);   // 테스트용
    }

    private static List<Integer> generateNumber() {
        // 지정 길이가 될 때까지 서로 다른 랜덤 숫자 추가
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