package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerService {
    private int N = Variables.NUM.getValue();

    public List<Integer> create(){
        List<Integer> list = new ArrayList<>();

        while (list.size() < N){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randomNumber)){
                list.add(randomNumber);
            }
        }

        return list;
    }

    public Computer createComputer(){
        return new Computer(create());
    }

}
