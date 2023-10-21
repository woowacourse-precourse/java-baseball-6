package baseball.vo;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers = new ArrayList<>();

    public Computer(List<Integer> randomNumber){
        this.computerNumbers=randomNumber;
    }

    public int getNumber(int index){
        return computerNumbers.get(index);
    }

    public int getIndex(int number){
        return computerNumbers.indexOf(number);
    }

    @Override
    public String toString() {
        return "RandomNumbers: "+computerNumbers;
    }
}
