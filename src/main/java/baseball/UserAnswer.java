package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserAnswer {
    private List<Integer> value;

    UserAnswer(String str) {
        this.value = validate(str.split(""));
    }

    List<Integer> validate(String[] inputVal) {
        List<Integer> answer = new ArrayList<>();
        try {
            IllegalArgumentException e = new IllegalArgumentException("입력값이 올바르지 않습니다.");
            for (int i = 0; i < inputVal.length; i++) {
                answer.add(Integer.parseInt(inputVal[i]));
            }
            if (answer.size() != 3 || answer.contains(0)) {
                e.printStackTrace();
                throw e;
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return answer;
    }

    void changeValue(String str) {
        this.value = validate(str.split(""));
    }

    int getSize() {
        return value.size();
    }

    Integer getValue(int index) {
        return value.get(index);
    }

    void clear() {
        value.clear();
    }
}
