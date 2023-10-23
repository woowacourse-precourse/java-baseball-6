package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computer = new ArrayList<>();

    public void selectRandomNumber(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void printComputerNumber(){
        System.out.println("Computer.printComputerNumber");
        for (Integer num : computer) {
            System.out.print(num);
        }
    }
}
