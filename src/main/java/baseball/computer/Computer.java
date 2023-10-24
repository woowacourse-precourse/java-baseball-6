package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String number;

    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return this.number;
    }

    public void makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        setNumber(makeNumberToString(computerNumber));
    }
    private String  makeNumberToString(List<Integer> number){
        StringBuilder numberToString = new StringBuilder();
        for (int index = 0; index < 3; index++){
            numberToString.append(number.get(index).toString());
        }
        return numberToString.toString();
    }
}
