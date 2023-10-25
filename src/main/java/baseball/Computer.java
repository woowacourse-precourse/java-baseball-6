package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {
    private List<Integer> computerInput = null;
    Computer(){
        computerInput = new ArrayList<>();
        renewDigit();
    }
    public void renewDigit(){
        computerInput= IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .boxed()
                .toList();
    }
    public List<Integer> getComputerInput(){
        return computerInput;
    }
}
