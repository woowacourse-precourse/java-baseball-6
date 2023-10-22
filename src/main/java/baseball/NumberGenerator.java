package baseball;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

  public List generate() {
    List<Integer> numList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    Collections.shuffle(numList);

    List<Integer> result = new ArrayList<>(3);
    result.add(numList.get(0));
    result.add(numList.get(1));
    result.add(numList.get(2));

    return result;
    }

}
