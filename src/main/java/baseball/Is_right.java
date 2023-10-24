package baseball;

import java.util.ArrayList;
import java.util.List;

public class Is_right {


    // 사용자가 서로 다른 3자리의 수를 입력하였는지 확인하는 기능
    public int checkRight(List<Integer> num_player) {
        int wrong = 0;
        List<Integer> equal = new ArrayList<>();
        equal.add(num_player.get(0));
        for (int i = 1; i < num_player.size(); i++) {
            if (equal.contains(num_player.get(i))) {
                wrong += 1;
            }
            equal.add(num_player.get(i));
        }
        return wrong;
    }

}
