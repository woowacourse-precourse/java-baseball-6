package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Number {
    private ArrayList<Integer> number;

    public Number() {
        number = new ArrayList<>();
    }

    public void setNumber(ArrayList<Integer> number) {
        this.number = number;
    }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    public void getComputerRandomNumber() {
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }
}