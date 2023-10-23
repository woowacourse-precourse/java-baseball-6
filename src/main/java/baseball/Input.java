package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Input {

    private final List<Integer> inputs;

    Input(String s) throws IllegalArgumentException {
        this.inputs = new ArrayList<>();

        for (char c : s.toCharArray()) {
            inputs.add(Character.getNumericValue(c));
        }
        if (inputs.size() != 3) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicateElements(inputs)) {
            throw new IllegalArgumentException();
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

    List<Integer> getNumber() {
        return inputs;
    }

    static int isEnd(String d) {
        int returnNumber = 0;
        try {
            int i = Integer.parseInt(d);
            if (i == 1) {
                returnNumber = 1;
            } else if (i == 2) {
                System.out.println("게임이 종료 되었습니다.");
            } else {
                throw new IllegalArgumentException();
            }
            return returnNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}