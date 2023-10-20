package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrikeOrBall {
    public static Map strikeOrBall (List<Integer> computers, List<Integer> users) {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<3; i++) {
            // 만약 난수에 입력 수가 있다면
            if (computers.contains(users.get(i))) {
                // 자리도 같다면 strike
                if (computers.get(i) == users.get(i)) {
                    strike += 1;
                }
                // 난수에 숫자가 존재하지만 자리가 다르다면 볼
                else {
                    ball += 1;
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("strike", strike);
        map.put("ball", ball);
        return map;
    }
}
