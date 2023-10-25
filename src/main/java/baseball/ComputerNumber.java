package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Integer> numberList;
    private static int size;
    public ComputerNumber(){
        numberList = new ArrayList<>();
        size = 3;
    }

    public void setNumberList(){
        while (numberList.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
    }
    public static void setSize(int newSize) {
        size = newSize;
    }
    public List<Integer> getNumberList(){
        return numberList;
    }
}
