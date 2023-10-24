package baseball.error;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class CheckerForRangeOfInputBalls {
    private Integer MAX_CAPACITY = 3;
    public void check(String numberString){
        List<String> tempNumCharList = new ArrayList(Arrays.asList(numberString.split("")));

        Stream<Integer> tempNumIntegerList = tempNumCharList.stream().map(tempNumChar -> Integer.parseInt(tempNumChar));
        Stream<Integer> filteredNumIntegerList = tempNumIntegerList.filter(tempNumInteger -> 1<=tempNumInteger && tempNumInteger <= 9);

        if (filteredNumIntegerList.count() != MAX_CAPACITY){
            throw new IllegalArgumentException();
        }
    }
}
