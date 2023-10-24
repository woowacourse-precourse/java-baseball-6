package baseball.Controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameStart {
    public String randomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        
        String computerInput = "";
        for(int i = 0; i < computer.size(); i++){
            computerInput += computer.get(i);
        }
        return computerInput;
    }
}
