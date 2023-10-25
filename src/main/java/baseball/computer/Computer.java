package baseball.computer;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    ComputerService service;
    public Computer(){
        service = new ComputerService();
    }
    //서로 다른 수 뽑기
    public List<Integer> selectNumbers(){
        List<Integer> numbers = new ArrayList<>();
        int numbersLength =1;
        int candidate;
        while(numbersLength <= 3){
            candidate = pickNumberInRange(1,9);
            if(service.isNotDuplicatedNum(numbers,candidate)){
                numbers.add(candidate);
                numbersLength++;
            }
        }
        return numbers;
    }

}
