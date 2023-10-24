package baseball.error;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class CheckerForDuplicationOfInputBalls {
    private final Integer MAX_CAPACITY = 3;
    private final Integer MAX_FREQUENCY_OF_COUNT = 1;
    public void check(String numberString){
        List<String> tempNumCharList = new ArrayList(Arrays.asList(numberString.split("")));
        List<Integer> countOfExisitingNumberList = new ArrayList();
        for (String tempNumChar : tempNumCharList) {
            countOfExisitingNumberList.add(Collections.frequency(tempNumCharList, tempNumChar));
        }
        if (Collections.frequency(countOfExisitingNumberList,MAX_FREQUENCY_OF_COUNT) != MAX_CAPACITY){
            throw new IllegalArgumentException();
        }
    }
}
