package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public void validateInputData(String inputData) {
        String[] dataList = inputData.split("");
        List<String> identifiedDataList = new ArrayList<>();
        if (dataList.length != 3) {
            throw new IllegalArgumentException("입력해야 할 값은 세자리 수 입니다.");
        }
        for (String data : dataList) {
            try {
                Integer.parseInt(data);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력해야 할 값은 0 ~ 9 숫자만 가능합니다.");
            }
            if (identifiedDataList.contains(data)) {
                throw new IllegalArgumentException("입력해야 할 값은 중복을 허용하지 않습니다.");
            }
            identifiedDataList.add(data);
        }
    }

    public void validateChoiceData(String choiceData) {
        if (choiceData.length() != 1) {
            throw new IllegalArgumentException("입력해야 할 값은 한자리 수 입니다.");
        }
        if (!choiceData.equals("1") && !choiceData.equals("2")) {
            throw new IllegalArgumentException("입력해야 할 값은 1 또는 2 숫자만 가능합니다.");
        }
    }
}
