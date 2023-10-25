package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Input {

    private final List<Integer> inputs;

    Input(){
        this.inputs = new ArrayList<>();
    }

    void setRandomNumber() {
        while (inputs.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!inputs.contains(randomNumber)) {
                inputs.add(randomNumber);
            }
        }
    }

    void setPlayerNumber (String s) throws IllegalArgumentException {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)){
                throw new IllegalArgumentException("1부터 9까지 서로 다른 3개의 숫자만 입력해 주세요");
            }
            inputs.add(Character.getNumericValue(c));
        }
        if (inputs.size() != 3 || hasDuplicateElements(inputs) || inputs.contains(0)) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 3개의 숫자만 입력해 주세요");
        }
    }

    boolean hasDuplicateElements(List<Integer> list) {
        Map<Object, Integer> elementCounts = new HashMap<>();

        for (Object element : list) {
            elementCounts.put(element, elementCounts.getOrDefault(element, 0) + 1);
            if (elementCounts.get(element) > 1) {
                return true;
            }
        }

        return false;
    }

    List<Integer> getNumber() { //get 말고 다른 방법이 있진 않았을까?
        return inputs;
    }

    static boolean isEnd(String d) throws IllegalArgumentException {
        int endNumber = Integer.parseInt(d);

        return switch (endNumber) {
            case 1 -> false;
            case 2 -> {
                System.out.println("게임이 종료 되었습니다.");
                yield true;
            }
            default -> throw new IllegalArgumentException("1 또는 2만 입력해주세요");
        };
    }
}