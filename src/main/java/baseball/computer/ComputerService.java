package baseball.computer;

import java.util.List;

public class ComputerService {
    public boolean isNotDuplicatedNum(List<Integer> numbers, Integer candidate){
        if(numbers.contains(candidate)){
            return false;
        }
        return true;
    }


}
