package baseball.check;

import java.util.ArrayList;
import java.util.List;

public class CheckServiceImpl implements CheckService {

    @Override
    public Hint checkNumber(List<Integer> computer, List<Integer> numbers) {
        Hint hint = new Hint();
        for(int i = 0; i < computer.size(); i++){
            if(computer.get(i).equals(numbers.get(i))){
                hint.strikeCounting();
                continue;
            }
            if(computer.contains(numbers.get(i))){
                hint.ballCounting();
            }
        }
        return hint;
    }

    @Override
    public boolean checkGameOver(Hint hint) {
        return hint.getStrike() == 3;
    }
}
