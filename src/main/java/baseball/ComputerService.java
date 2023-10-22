package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerService {
    private int N = Variables.NUM.getValue();

    private int randomMaker(){
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    public List<Integer> create(){
        List<Integer> list = new ArrayList<>();

        while (list.size() < N){
            int randomNumber = randomMaker();
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
