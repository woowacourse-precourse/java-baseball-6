package baseball.Player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Pitcher implements BaseballPlayer {
    private List<Integer> choice;

    @Override
    public void makeChoice(){
        choice = new ArrayList<>();
        while(choice.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!choice.contains(randomNumber)) {
                choice.add(randomNumber);
            }
        }
    }

    public List<Integer> getChoice(){
        return this.choice;
    }
}
