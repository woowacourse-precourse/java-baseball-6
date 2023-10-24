package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameCompetitor {
    private List<Integer> CompititorNumber = new ArrayList<>();
    public List<Integer> generateRandomNumber(){
        while (CompititorNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!CompititorNumber.contains(randomNumber)) {
                CompititorNumber.add(randomNumber);
            }
        }
        System.out.println(CompititorNumber);
        return CompititorNumber;
    }
}


