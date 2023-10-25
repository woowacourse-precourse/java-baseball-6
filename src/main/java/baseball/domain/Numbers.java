package baseball.domain;

import static baseball.enums.NumbersEnum.*;


import baseball.exception.NumberDuplicationException;
import baseball.exception.WrongLengthException;
import baseball.vo.Number;
import java.util.List;
import java.util.stream.Collectors;

public interface Numbers {



    default void checkDuplication(List<Number> integers) {
        List<Number> distinctNumbers = integers.stream()
                                               .distinct()
                                               .toList();

        if (distinctNumbers.size() != integers.size()) {
            throw new NumberDuplicationException();
        }
    }

    default void checkLength(List<Number> integers) {

        if (integers.size() != LENGTH.showValue()) {
            throw new WrongLengthException();
        }
    }


}
