package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Baseball {

    List<Integer> ballNum;

    public Baseball() {
        ballNum = new ArrayList<>();

    }

    public List<Integer> getBallNum() {
        return this.ballNum;
    }

    public void makeBaseball() {

        while (ballNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!ballNum.contains(randomNumber)) {
                ballNum.add(randomNumber);
            }
        }

    }
}
