package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static baseball.Constant.*;

public class Computer {

    private List<Integer> computerNumber = new ArrayList<>();

    public Computer(){
        int count = 0;
        while(count < VALID_INPUT_LENGTH) {
            Integer number = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (computerNumber.contains(number)) continue; //중복수 제거
            count++;
            computerNumber.add(number);
        }
    }

    public List<Integer> getComputerNumber(){
        return computerNumber;
    }

}