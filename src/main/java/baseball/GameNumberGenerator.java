package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
public class GameNumberGenerator {
    public List<Integer> gameNumber = new ArrayList<>();
    public void generateNumber() {
        gameNumber = new ArrayList<>();
        while (gameNumber.size() < 3) {
            addGameNumber(pickRandomNumber());
        }
    }
    public static int pickRandomNumber(){
        return Randoms.pickNumberInRange(1, 9);
    }
    public void addGameNumber(int randomNumber){
        if (!gameNumber.contains(randomNumber)) {
            gameNumber.add(randomNumber);
        }
    }
}
