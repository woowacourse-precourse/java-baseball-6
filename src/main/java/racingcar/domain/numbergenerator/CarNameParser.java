package racingcar.domain.numbergenerator;

import java.util.*;
import racingcar.domain.CarName;

public class CarNameParser {
    private static final String INPUT_NAMES_REGEX = "^[A-Za-z0-9,]*[A-Za-z0-9]$";
    private static final String NAME_DELIMITER = ",";

    public static List<CarName> parse(String inputNames) {
        validateInputNames(inputNames);

        return Arrays.stream(inputNames.split(NAME_DELIMITER))
                .map(CarName::new)
                .toList();
    }

    private static void validateInputNames(String inputNames) {
        if (!inputNames.matches(INPUT_NAMES_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 이름 입력 형식이 맞지 않습니다.");
        }
        List<String> nameList = List.of(inputNames.split(NAME_DELIMITER));
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameList.size() != nameSet.size()) {
            throw new IllegalArgumentException("[ERROR] 이름이 중복됩니다.");
        }
    }
}
