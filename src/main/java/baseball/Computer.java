package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computer = new ArrayList<>();

    public void init(){
        computer.clear();
    }

    public void selectRandomNumber(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void setComputerObject(){
        init();
        selectRandomNumber();
    }

    public int getComputerNumber(int index){
        return computer.get(index);
    }

    public boolean isComputerContains(int number){
        return computer.contains(number);
    }

    public void printComputerNumber(){
        System.out.println("Computer.printComputerNumber");
        for (Integer num : computer) {
            System.out.print(num);
        }
    }
}
