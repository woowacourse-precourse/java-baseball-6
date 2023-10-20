package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

public class Opponent extends PlayerEntity {
    @Override
    public void setNumberList() {
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            // avoid duplicates
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
    }
}
