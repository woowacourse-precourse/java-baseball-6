package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Computer {
    private String number;
    public String getNumber() {
        return number;
    }
    public void setNumber() {
        LinkedHashSet<String> number = new LinkedHashSet<>();
        while(number.size() < 3){
            number.add(Integer.toString(Randoms.pickNumberInRange(1, 9)));
        }
        this.number = String.join("", number);
    }
}