package baseball.domain;

import static baseball.enums.NumbersEnum.*;

import baseball.enums.NumbersEnum;
import baseball.exception.WrongLengthException;
import java.util.List;
import java.util.stream.Collectors;

public interface Numbers {

    default void checkDuplication(List<Integer> integers) {
        List<Integer> duplicationCheckList = integers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (duplicationCheckList.size() != integers.size()) {
            throw new WrongLengthException();
        }
    }

    default void checkLength(List<Integer> integers) {

        if (integers.size() != LENGTH.showValue()) {
            throw new WrongLengthException();
        }
    }
}
