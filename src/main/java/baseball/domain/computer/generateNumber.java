package baseball.domain.computer;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class generateNumber {
    List<Integer> computer = new ArrayList<>();

    while(computer.size() <= 3){
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        // No Duplication
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
    }


}
