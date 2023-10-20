package baseball;

import java.util.List;

public class ResultGenerator {
    public List<Integer> makeResult(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strike =0;
        int ball =0;
        for (int i = 0; i < userNumbers.size(); i++) {
            int thisUserNumber = userNumbers.get(i);
            int thisComputerNumber = computerNumbers.get(i);
            if (thisUserNumber==thisComputerNumber){
                strike++;
                continue;
            }
            if(computerNumbers.contains(thisUserNumber))
                ball++;
        }
        return List.of(strike,ball);
    }
}
