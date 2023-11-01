package racingcar.domain;

import java.util.*;

public class CarNameParser {
    private static final String INPUT_NAMES_REGEX = "^[가-힣A-Za-z0-9,]*[가-힣A-Za-z0-9]$";
    private static final String NAME_DELIMITER = ",";

    public List<CarName> parse(String inputNames) {
        validateInputNames(inputNames);

        return Arrays.stream(inputNames.split(NAME_DELIMITER))
                .map(CarName::new)
                .toList();
    }

    private void validateInputNames(String inputNames) {
        if (!inputNames.contains(NAME_DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 2대 이상의 자동차 이름을 쉼표로 구분하여 입력해주세요.");
        }
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
