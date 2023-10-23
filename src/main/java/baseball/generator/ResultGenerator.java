package baseball.generator;

import baseball.dto.GameResult;

import java.util.List;

public class ResultGenerator {
    public GameResult makeResult(List<Integer> userNumbers, List<Integer> computerNumbers) {
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
        return new GameResult(strike,ball);
    }
}
