package baseball.service;

import baseball.model.Game;
import baseball.model.Number;

public class BaseballService {

    public int getBallCount (Number computer , Number user){
        int ballCount = 0;
        for (int i = 0; i< Game.SIZE; i++) {
            Integer x = user.get(i);
            Integer y = computer.get(i);
            if (!(x.equals(y)) && computer.contains(x)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int getStrikeCount (Number computer , Number user){
        int strikeCount = 0;
        for (int i = 0; i<Game.SIZE; i++) {
            Integer x = user.get(i);
            Integer y = computer.get(i);
            if (x.equals(y)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
