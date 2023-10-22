package baseball.utill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public List<Integer> convertToNumericList(List<String> stringList) {
        return stringList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
