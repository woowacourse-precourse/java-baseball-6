package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
    private List<Integer> numberList;

    public NumberList() {
        numberList = new ArrayList<>();
    }
    public NumberList(List<Integer> numberList){
        this.numberList = numberList;
    };

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public boolean equals(NumberList a) {
        boolean isEqual = true;
        for(int i = 0; i< numberList.size(); i++) {
            isEqual &= (numberList.get(i).equals(a.numberList.get(i)));
        }
        return isEqual;
    }
}
