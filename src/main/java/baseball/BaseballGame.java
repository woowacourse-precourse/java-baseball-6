package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private List<Integer> computer;
    private String PNum;

    public List<Integer> random(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public String InputNum() {
        String PNum = Console.readLine();
        return PNum;
    }



    public void run() {
        computer = random();
        PNum = InputNum();
    }
}
