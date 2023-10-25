package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer{
    ArrayList<Integer> number = new ArrayList<>();

    public ArrayList<Integer> createComputerNumber() {
        number.clear();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    public ArrayList<Integer> getNumber(){
        return number;
    }

}
