package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingAnswer {

    /*
    1️⃣ 정답을 만드는 기능
    - 상대방 (컴퓨터) 의 3자리 수를 랜덤하게 생성한다.
    */

    private int random_number;

    public CreatingAnswer() {
    }

    public int getRandomNumber() {

        ArrayList<Integer> randomList = new ArrayList<>();
        while (randomList.size() < 3) {
            int tempNum = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(tempNum)) {
                randomList.add(tempNum);
            }
        }

        String str = randomList.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining());
        System.out.println(str);
        System.out.println(Integer.parseInt(str));
        return Integer.parseInt(str);
    }

}
