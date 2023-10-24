package baseball;

import java.util.ArrayList;
import java.util.List;

public class judge {

    int judgement(List<Integer> user, List<Integer> com) {
        List<Integer> userNum = new ArrayList<>(user);
        List<Integer> comNum = new ArrayList<>(com);
        int Strike = 0;
        int Ball = 0;

        for (int i = 0; i < 3; i++) {
            if (comNum.get(i) == userNum.get(i))
                Strike++;
            if (comNum.get(i) != userNum.get(i) && comNum.contains(userNum.get(i)))
                Ball++;
        }

        if (Strike == 3) {
            System.out.println(Strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 3;
        }
        if (Strike == 0 && Ball == 0)
            System.out.println("낫싱");
        if (Strike == 0 && Ball != 0)
            System.out.println(Ball + "볼");
        if (Ball == 0 && Strike != 0)
            System.out.println(Strike + "스트라이크");
        if (Strike != 0 && Ball != 0)
            System.out.println(Ball + "볼" + " " + Strike + "스트라이크");
        return 0;
    }
}