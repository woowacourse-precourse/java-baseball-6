package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private ArrayList<Integer> computer;

    public Computer() {
        computer = new ArrayList<>();
        generateComputerNumber();
    }
    private void generateComputerNumber() {
        while (computer.size() < 3 ) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }
    public ArrayList<Integer> getComputerNums(){
        return computer;
    }

}