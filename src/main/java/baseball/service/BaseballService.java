package baseball.service;

import baseball.model.Number;

public class BaseballService {

    public int getBallCount (Number computer , Number user){
        int BallCount = 0;
        for (int i = 0; i<Number.getGameSize(); i++) {
            Integer x = user.get(i);
            Integer y = computer.get(i);
            if ((x != y) && computer.contains(x)) {
                BallCount++;
            }
        }
        return BallCount;
    }

}
