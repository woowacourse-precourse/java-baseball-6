package baseball.global.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import baseball.Game;

public class RandomUtil {

    public static List<Character> randomNumber() {
        List<Character> computer = new ArrayList<>();
        while (computer.size() < Game.INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Game.MIN_NUMBER, Game.MAX_NUMBER);
            Character numToChar = Character.forDigit(randomNumber, 10);
            
            if (!computer.contains(numToChar)) {
                computer.add(numToChar);
            }
        }
        
        return computer;
    }
}
