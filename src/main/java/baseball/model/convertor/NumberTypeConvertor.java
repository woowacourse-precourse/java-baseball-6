package baseball.model.convertor;

import java.util.ArrayList;
import java.util.List;

public class NumberTypeConvertor {
    public List<Integer> toListInteger(String numStr) {
        List<Integer> numInts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int toInt = Character.getNumericValue(numStr.charAt(i));
            numInts.add(toInt);
        }
        return numInts;
    }
}
