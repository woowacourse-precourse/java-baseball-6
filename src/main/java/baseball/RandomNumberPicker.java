package baseball;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RandomNumberPicker {
    List<Integer> randomNumbers = new ArrayList<>();

    public List<Integer> pickRandomNums(){
        List<Integer> numbers = new ArrayList<>();

        for (int i=1;i<=9;i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for(int i=0;i<3;i++){
            randomNumbers.add(numbers.get(i));
        }

        return randomNumbers;
    }

}
